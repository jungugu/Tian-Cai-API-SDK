package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.request;

import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.enums.RequestMethodEum;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.params.RandomAvatarParams;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.RandomAvatarResponse;
import lombok.experimental.Accessors;

/**
 * @author NuoMi
 */
@Accessors(chain = true)
public class RandomAvatarRequest extends BaseRequest<RandomAvatarParams, RandomAvatarResponse> {
    @Override
    public String getMethod() {
        return RequestMethodEum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/randomAvatar";
    }

    @Override
    public Class<RandomAvatarResponse> getResponseClass() {
        return RandomAvatarResponse.class;
    }
}
