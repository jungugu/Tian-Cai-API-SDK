package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NuoMi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TianCaiApiClient {
    private static final String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;
}
