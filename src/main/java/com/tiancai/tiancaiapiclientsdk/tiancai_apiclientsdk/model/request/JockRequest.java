package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.request;

import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.enums.RequestMethodEum;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.params.JockParams;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.params.RandomAvatarParams;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.JockResponse;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.RandomAvatarResponse;
import lombok.experimental.Accessors;

/**
 * @author NuoMi
 */
@Accessors(chain = true)
public class JockRequest extends BaseRequest<JockParams, JockResponse> {
    @Override
    public String getMethod() {
        return RequestMethodEum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/jock";
    }

    @Override
    public Class<JockResponse> getResponseClass() {
        return JockResponse.class;
    }
}
