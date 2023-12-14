package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.request;

import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.enums.RequestMethodEum;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.params.NameParams;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response.NameResponse;
import lombok.experimental.Accessors;


/**
 * @author NuoMi
 */
@Accessors(chain = true)
public class NameRequest extends BaseRequest<NameParams, NameResponse> {

    @Override
    public String getMethod() {
        return RequestMethodEum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/name/get";
    }

    @Override
    public Class<NameResponse> getResponseClass() {
        return NameResponse.class;
    }
}
