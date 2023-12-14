package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.request;

import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.enums.RequestMethodEum;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.params.NameParams;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.params.RefuseClassificationParams;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.NameResponse;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.RefuseClassificationResponse;
import lombok.experimental.Accessors;


/**
 * @author NuoMi
 */
@Accessors(chain = true)
public class RefuseClassificationRequest extends BaseRequest<RefuseClassificationParams, RefuseClassificationResponse> {

    @Override
    public String getMethod() {
        return RequestMethodEum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/refuseClassification";
    }

    @Override
    public Class<RefuseClassificationResponse> getResponseClass() {
        return RefuseClassificationResponse.class;
    }
}
