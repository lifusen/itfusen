package com.itfusen.domain.enums;

public enum ResponseEnum {
	SUCCESS(1001, "success"),
	FAILED(1002, "failed"),
	USER_INSERT_ERROR(1003, "用户新增异常"),
	USER_UPDATE_ERROR(1004, "用户修改异常"),
	USER_LOGIN_ERROR(1005, "账户或者密码不正确");
	
	private int code;
	private String message;

	private ResponseEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}