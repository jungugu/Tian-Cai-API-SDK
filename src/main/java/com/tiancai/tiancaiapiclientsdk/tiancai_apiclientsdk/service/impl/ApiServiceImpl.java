package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.service.impl;

import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.client.TianCaiApiClient;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.exception.ApiException;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.request.*;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.HoroscopeResponse;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.RefuseClassificationResponse;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.ResultResponse;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.service.ApiService;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.service.BaseService;

/**
 * @author NuoMi
 */
public class ApiServiceImpl extends BaseService implements ApiService {

    @Override
    public ResultResponse getName(NameRequest nameRequest) throws ApiException {
        return request(nameRequest);
    }

    @Override
    public ResultResponse getName(NameRequest nameRequest, TianCaiApiClient tianCaiApiClient) throws ApiException {
        return request(nameRequest, tianCaiApiClient);
    }

    @Override
    public ResultResponse randomAvatar(RandomAvatarRequest request) throws ApiException {
        return request(request);
    }

    @Override
    public ResultResponse randomAvatar(RandomAvatarRequest request, TianCaiApiClient tianCaiApiClient) throws ApiException {
        return request(request, tianCaiApiClient);
    }

    @Override
    public ResultResponse poisonousChickenSoup(PoisonousChickenSoupRequest poisonousChickenSoupRequest) throws ApiException {
        return request(poisonousChickenSoupRequest);
    }

    @Override
    public ResultResponse poisonousChickenSoup(PoisonousChickenSoupRequest poisonousChickenSoupRequest, TianCaiApiClient tianCaiApiClient) throws ApiException {
        return request(poisonousChickenSoupRequest, tianCaiApiClient);
    }

    @Override
    public ResultResponse jock(JockRequest jockRequest) throws ApiException {
        return request(jockRequest);
    }

    @Override
    public ResultResponse jock(JockRequest jockRequest, TianCaiApiClient tianCaiApiClient) throws ApiException {
        return request(jockRequest, tianCaiApiClient);
    }

    @Override
    public ResultResponse efuseClassification(RefuseClassificationRequest refuseClassificationRequest) throws ApiException {
        return request(refuseClassificationRequest);
    }

    @Override
    public ResultResponse efuseClassification(RefuseClassificationRequest refuseClassificationRequest, TianCaiApiClient tianCaiApiClient) throws ApiException {
        return request(refuseClassificationRequest, tianCaiApiClient);
    }

    @Override
    public ResultResponse horoscope(HoroscopeRequest horoscopeRequest) throws ApiException {
        return request(horoscopeRequest);
    }

    @Override
    public ResultResponse horoscope(HoroscopeRequest horoscopeRequest, TianCaiApiClient tianCaiApiClient) throws ApiException {
        return request(horoscopeRequest, tianCaiApiClient);
    }
}
