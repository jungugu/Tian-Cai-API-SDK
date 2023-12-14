package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.request;

import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.enums.RequestMethodEum;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.params.PoisonousChickenSoupParams;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.params.RandomAvatarParams;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.PoisonousChickenSoupResponse;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.RandomAvatarResponse;
import lombok.experimental.Accessors;

/**
 * @author NuoMi
 */
@Accessors(chain = true)
public class PoisonousChickenSoupRequest extends BaseRequest<PoisonousChickenSoupParams, PoisonousChickenSoupResponse> {
    @Override
    public String getMethod() {
        return RequestMethodEum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/poisonousChickenSoup";
    }

    @Override
    public Class<PoisonousChickenSoupResponse> getResponseClass() {
        return PoisonousChickenSoupResponse.class;
    }
}
