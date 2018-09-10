package com.mikola.demolibrary.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by Mikola on  Sep 10, 2018
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String code;
    private String message;
    private Object data;

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
