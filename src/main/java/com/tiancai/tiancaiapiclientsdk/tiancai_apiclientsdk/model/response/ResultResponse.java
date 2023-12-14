package com.tiancai.tiancaiapiclientsdk.tiancai_apiclientsdk.model.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * @author NuoMi
 */
@Data
@NoArgsConstructor
public class ResultResponse implements Serializable {
    private static final long serialVersionUID = -6486005224268968744L;

    private Map<String, Object> data = new HashMap<>();

    /**
     * @JsonAnyGetter 是标识在一个返回Map的方法上的。
     * 标识后，
     * Jackson会把该方法返回的Map里的的Key和Value序列化为JSON。
     * @return
     */
    @JsonAnyGetter
    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
