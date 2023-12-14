package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.exception;

import lombok.Data;

/**
 * @author NuoMi
 */
@Data
public class ErrorResponse {
    private String message;
    private int code;
}
