package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.service;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.client.TianCaiApiClient;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.exception.ApiException;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.exception.ErrorCode;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.exception.ErrorResponse;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.request.BaseRequest;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.ResultResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.utils.SignUtils.genSign;

/**
 * @author NuoMi
 */
@Slf4j
@Data
public abstract class BaseService implements ApiService {

    private TianCaiApiClient tianCaiApiClient;

    /**
     * 网关HOST
     */
    private String gatewayHost = "http://localhost:8090/api";

    /**
     * 检查配置
     *
     * @param tianCaiApiClient
     * @throws ApiException
     */
    public void checkConfig(TianCaiApiClient tianCaiApiClient) throws ApiException {
        if (tianCaiApiClient == null && this.getTianCaiApiClient() == null) {
            throw new ApiException(ErrorCode.NO_AUTH_ERROR, "请配置accessKey,secretKey");
        }
        if (tianCaiApiClient != null && !StringUtils.isAnyBlank(tianCaiApiClient.getAccessKey(), tianCaiApiClient.getSecretKey())) {
            this.setTianCaiApiClient(tianCaiApiClient);
        }
    }

    /**
     * 发起请求
     *
     * @param request
     * @param <O>
     * @param <T>
     * @return
     * @throws ApiException
     */
    private <O, T extends ResultResponse> HttpResponse doRequest(BaseRequest<O, T> request) throws ApiException {
        HttpRequest httpRequest;
        try {
            httpRequest = getHttpRequestByRequestMethod(request);
        } catch (ApiException e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
        return httpRequest.execute();
    }

    /**
     * 通过Method和path 获取 HttpRequest 用于执行 http请求
     *
     * @param request
     * @param <O>
     * @param <T>
     * @return
     * @throws ApiException
     */
    private <O, T extends ResultResponse> HttpRequest getHttpRequestByRequestMethod(BaseRequest<O, T> request) throws ApiException {
        // 获取path和method并校验
        if (ObjectUtils.isEmpty(request)) {
            throw new ApiException(ErrorCode.PARAMS_ERROR);
        }
        String path = request.getPath().trim();
        String method = request.getMethod().trim().toUpperCase();
        if (StringUtils.isEmpty(path)) {
            throw new ApiException(ErrorCode.PARAMS_ERROR, "请求地址为空");
        }

        if (StringUtils.isEmpty(method)) {
            throw new ApiException(ErrorCode.PARAMS_ERROR, "请求方法为空");
        }
        if (path.startsWith(getGatewayHost())) {
            path = path.substring(getGatewayHost().length());
        }
        log.info("请求方法：{}，请求路径：{}，请求参数：{}", method, path, request.getRequestParams());
        // 根据method构造HttpRequest
        HttpRequest httpRequest;
        switch (method) {
            case "GET": {
                httpRequest = HttpRequest.get(splicingGetRequest(request, path));
                break;
            }
            case "POST": {
                httpRequest = HttpRequest.post(gatewayHost + path);
                break;
            }
            default: {
                throw new ApiException(ErrorCode.PARAMS_ERROR, "不支持该请求" + method);
            }
        }
        return httpRequest.addHeaders(getHeaders(JSONUtil.toJsonStr(request), tianCaiApiClient)).body(JSONUtil.toJsonStr(request.getRequestParams()));
    }

    /**
     * 拼接Get请求
     *
     * @param request
     * @param path
     * @param <O>
     * @param <T>
     * @return
     */
    private <O, T extends ResultResponse> String splicingGetRequest(BaseRequest<O, T> request, String path) {
        StringBuilder urlBuilder = new StringBuilder(gatewayHost);
        // urlBuilder最后是/结尾且path以/开头的情况下，去掉urlBuilder结尾的/
        if (urlBuilder.toString().endsWith("/") && path.startsWith("/")) {
            urlBuilder.setLength(urlBuilder.length() - 1);
        }
        urlBuilder.append(path);
        // 参数不为空进行拼接
        if (!request.getRequestParams().isEmpty()) {
            urlBuilder.append("?");
            for (Map.Entry<String, Object> entry : request.getRequestParams().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                urlBuilder.append(key).append("=").append(value).append("&");
            }
            log.info("Get 请求路径：{}", urlBuilder);
        }
        return urlBuilder.toString();
    }

    /**
     * 获取请求头
     *
     * @param body
     * @param tianCaiApiClient
     * @return
     */
    private Map<String, String> getHeaders(String body, TianCaiApiClient tianCaiApiClient) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", tianCaiApiClient.getAccessKey());
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, tianCaiApiClient.getSecretKey()));
        return hashMap;
    }

    /**
     * 获取响应数据
     * @param request
     * @return
     * @param <O>
     * @param <T>
     * @throws ApiException
     */
    public <O, T extends ResultResponse> T res(BaseRequest<O, T> request) throws ApiException {
        if (tianCaiApiClient == null || StringUtils.isAnyBlank(tianCaiApiClient.getAccessKey(), tianCaiApiClient.getSecretKey())) {
            throw new ApiException(ErrorCode.NO_AUTH_ERROR, "请配置密钥AccessKey,SecretKey");
        }
        // 实例化对应的 response 对象
        T rsp;
        try {
            Class<T> clazz = request.getResponseClass();
            rsp = clazz.newInstance();
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
        // 发起请求获取响应
        HttpResponse httpResponse = doRequest(request);
        String body = httpResponse.body();
        HashMap<String, Object> data = new HashMap<>();
        // 响应码不为成功时
        if (httpResponse.getStatus() != 200) {
            ErrorResponse errorResponse = JSONUtil.toBean(body, ErrorResponse.class);
            data.put("errorMessage", errorResponse.getMessage());
            data.put("code", errorResponse.getCode());
        } else {
            // 响应码为成功时
            try {
                // 尝试解析为JSON对象
                data = new Gson().fromJson(body, data.getClass());
            } catch (JsonSyntaxException e) {
                // 解析失败，将body作为普通字符串处理
                data.put("value", body);
            }
        }
        rsp.setData(data);
        return rsp;
    }


    @Override
    public <O, T extends ResultResponse> T request(BaseRequest<O, T> request) throws ApiException {
        try {
            return res(request);
        } catch (ApiException e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }

    @Override
    public <O, T extends ResultResponse> T request(BaseRequest<O, T> request, TianCaiApiClient tianCaiApiClient) throws ApiException {
        try {
            checkConfig(tianCaiApiClient);
            return res(request);
        } catch (ApiException e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }
}
