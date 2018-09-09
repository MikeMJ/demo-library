package com.mikola.demolibrary.response;

import lombok.Data;

/**
 * Created by Mikola on  Sep 10, 2018
 */
@Data
public class Response {
    private String code;
    private String message;
    private Object data;

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
