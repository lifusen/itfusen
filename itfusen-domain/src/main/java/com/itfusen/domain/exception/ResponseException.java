package com.itfusen.domain.exception;

import com.itfusen.domain.enums.ResponseEnum;

public class ResponseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private ResponseEnum errorEnum;

    public ResponseException(ResponseEnum errorEnum){
        this.errorEnum =errorEnum;
    }

    public ResponseEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ResponseEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
}
