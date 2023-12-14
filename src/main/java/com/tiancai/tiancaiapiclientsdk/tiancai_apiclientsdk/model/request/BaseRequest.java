package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.request;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.ResultResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * O 对应的参数类型
 * T 对应的Response
 * @author NuoMi
 */
public abstract class BaseRequest<O, T extends ResultResponse> {

    private Map<String, Object> requestParams = new HashMap<>();

    /**
     * get 方法
     * @return
     */
    public abstract String getMethod();

    /**
     * 获取 path
     * @return
     */
    public abstract String getPath();

    /**
     * 获取响应类
     * @return
     */
    public abstract Class<T> getResponseClass();

    @JsonAnyGetter
    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(O params) {
        this.requestParams = new Gson().fromJson(JSONUtil.toJsonStr(params), new TypeToken<Map<String, Object>>(){}.getType());
    }

}
