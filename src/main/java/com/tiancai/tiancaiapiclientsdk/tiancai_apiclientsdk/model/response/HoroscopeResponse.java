package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NuoMi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HoroscopeResponse extends ResultResponse {
    private static final long serialVersionUID = -1038984103811824271L;

    private String title;

    private String type;

    private String time;

    private HashMap<String, String> todo;

    private HashMap<String, String> fortune;

    private HashMap<String, String> index;

    private String luckynumber;

    private String luckycolor;

    private HashMap<String, String> fortunetext;
}
