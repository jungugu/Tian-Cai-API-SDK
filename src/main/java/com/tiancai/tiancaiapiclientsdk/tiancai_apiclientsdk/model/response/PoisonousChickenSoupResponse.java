package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author NuoMi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PoisonousChickenSoupResponse extends ResultResponse implements Serializable {
    private static final long serialVersionUID = -1038984103811824271L;

    private String text;
}
