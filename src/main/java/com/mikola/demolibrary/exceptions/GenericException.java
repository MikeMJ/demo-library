package com.mikola.demolibrary.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mikola on  Sep 10, 2018
 */

public abstract class GenericException extends Exception {
    private Logger logger = LoggerFactory.getLogger(GenericException.class);
    private String errorCode;

    public GenericException(String message, Exception cause, String errorCode, String... params){
        super(message,cause);
        this.errorCode = errorCode;
        StringBuilder sb = new StringBuilder(message);
        for (String param : params) {
            sb.append("[").append(param).append("]");
        }
        logger.error(message,cause);
    }

    public GenericException(String message, String errorCode, String... params){
        super(message);
        this.errorCode = errorCode;
        StringBuilder sb = new StringBuilder(message);
        for (String param : params) {
            sb.append("[").append(param).append("]");
        }
        logger.error(message);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
