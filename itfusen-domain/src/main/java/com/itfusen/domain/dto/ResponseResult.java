package com.itfusen.domain.dto;

import com.itfusen.domain.enums.ResponseEnum;

public class ResponseResult {

	private boolean result;
	private int code;
	private String message;
	private Object data;

	public ResponseResult() {

	}
	//success constructor
	public ResponseResult(ResponseEnum result, Object data) {
		this.result = true;
		this.code = result.getCode();
		this.message = result.getMessage();
		this.data = data;
	}
	
	//failed constructor
	public ResponseResult(ResponseEnum result) {
		this.result = false;
		this.code = result.getCode();
		this.message = result.getMessage();
	}
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
