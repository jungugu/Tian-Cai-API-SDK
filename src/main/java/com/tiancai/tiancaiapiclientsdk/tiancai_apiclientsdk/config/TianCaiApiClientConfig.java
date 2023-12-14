package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.config;

import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.client.TianCaiApiClient;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.service.ApiService;
import com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.service.impl.ApiServiceImpl;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author NuoMi
 */
@Configuration
@ConfigurationProperties("tiancaiapi.client")
@Data
@ComponentScan
public class TianCaiApiClientConfig {
    private String accessKey;
    private String secretKey;
    /**
     * 网关
     */
    private String host;

    @Bean
    public TianCaiApiClient tianCaiApiClient() {
        return new TianCaiApiClient(accessKey,secretKey);
    }

    @Bean
    public ApiService apiService() {
        ApiServiceImpl apiService = new ApiServiceImpl();
        apiService.setTianCaiApiClient(new TianCaiApiClient(accessKey,secretKey));
        if (StringUtils.isNotBlank(host)) {
            apiService.setGatewayHost(host);
        }
        return apiService;
    }



}
