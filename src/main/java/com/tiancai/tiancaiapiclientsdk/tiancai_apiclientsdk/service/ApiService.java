package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.service;

import cn.hutool.http.HttpResponse;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.client.TianCaiApiClient;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.exception.ApiException;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.request.*;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.HoroscopeResponse;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.ResultResponse;

/**
 * @author NuoMi
 */
public interface ApiService {

    /**
     * 通用请求
     *
     * @param request 要求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    <O, T extends ResultResponse> T request(BaseRequest<O, T> request) throws ApiException;

    /**
     * 通用请求
     *
     * @param tianCaiApiClient api客户端
     * @param request          要求
     * @return {@link T}
     * @throws ApiException 业务异常
     */
    <O, T extends ResultResponse> T request(BaseRequest<O, T> request, TianCaiApiClient tianCaiApiClient) throws ApiException;


    /**
     * 通用请求
     *
     * @param nameRequest 要求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getName(NameRequest nameRequest) throws ApiException;


    /**
     * 通用请求
     *
     * @param nameRequest 要求
     * @param tianCaiApiClient 客户端
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getName(NameRequest nameRequest, TianCaiApiClient tianCaiApiClient) throws ApiException;


    /**
     * 通用请求
     *
     * @param request 要求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse randomAvatar(RandomAvatarRequest request) throws ApiException;

    /**
     * 通用请求
     *
     * @param request 要求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse randomAvatar(RandomAvatarRequest request, TianCaiApiClient tianCaiApiClient) throws ApiException;

    /**
     * 通用请求
     *
     * @param poisonousChickenSoupRequest 要求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse poisonousChickenSoup(PoisonousChickenSoupRequest poisonousChickenSoupRequest) throws ApiException;

    /**
     * 通用请求
     *
     * @param poisonousChickenSoupRequest 要求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse poisonousChickenSoup(PoisonousChickenSoupRequest poisonousChickenSoupRequest, TianCaiApiClient tianCaiApiClient) throws ApiException;

    /**
     * 笑话请求
     * @param jockRequest
     * @return
     * @throws ApiException
     */
    ResultResponse jock(JockRequest jockRequest) throws ApiException;

    /**
     * 笑话请求
     * @param jockRequest
     * @return
     * @throws ApiException
     */
    ResultResponse jock(JockRequest jockRequest, TianCaiApiClient tianCaiApiClient) throws ApiException;

    /**
     * 笑话请求
     * @param refuseClassificationRequest
     * @return
     * @throws ApiException
     */
    ResultResponse efuseClassification(RefuseClassificationRequest refuseClassificationRequest) throws ApiException;

    /**
     * 笑话请求
     * @param refuseClassificationRequest
     * @return
     * @throws ApiException
     */
    ResultResponse efuseClassification(RefuseClassificationRequest refuseClassificationRequest, TianCaiApiClient tianCaiApiClient) throws ApiException;

    /**
     * 通用请求
     * @param horoscopeRequest 要求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse horoscope(HoroscopeRequest horoscopeRequest) throws ApiException;

    /**
     * 通用请求
     * @param tianCaiApiClient api客户端
     * @param horoscopeRequest          要求
     * @throws ApiException 业务异常
     */
    ResultResponse horoscope(HoroscopeRequest horoscopeRequest, TianCaiApiClient tianCaiApiClient) throws ApiException;
}
