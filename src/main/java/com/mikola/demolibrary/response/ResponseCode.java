package com.mikola.demolibrary.response;

/**
 * Created by Mikola on  Sep 10, 2018
 */
public enum ResponseCode {

    Ok("200"),
    NoSuchBook("400.1"),
    NoSuchUser("400.2"),
    BookReserved("400.3"),
    Internal("500.1");
    private String code;

    ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
