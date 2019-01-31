package com.itfusen.domain.sysconfig;

import java.util.Date;

import com.itfusen.domain.comm.BaseEntity;


/**
 * 系统日志
 * 
 */
public class SysLogEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	//用户名
	private String userName;
	//用户操作(注解上的内容)
	private String operation;
	//请求方法
	private String method;
	//请求参数
	private String parameters;
	//执行时长(毫秒)
	private Long time;
	//IP地址
	private String ip;
	//创建时间
	private Date createDate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
