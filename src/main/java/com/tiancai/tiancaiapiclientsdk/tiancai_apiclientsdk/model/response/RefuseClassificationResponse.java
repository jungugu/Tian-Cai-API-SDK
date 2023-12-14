package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author NuoMi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefuseClassificationResponse extends ResultResponse{
    private String name;
    private String sort;
}
