package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.enums;


/**
 * @author NuoMi
 */
public enum RequestMethodEum {
    /**
     *
     */
    GET("GET","GET"),
    POST("POST","POST")
    ;
    private String test;
    private String value;

    RequestMethodEum(String test, String value) {
        this.test = test;
        this.value = value;
    }

    public String getTest() {
        return test;
    }

    public String getValue() {
        return value;
    }
}
