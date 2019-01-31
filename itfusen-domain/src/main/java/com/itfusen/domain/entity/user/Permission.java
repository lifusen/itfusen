package com.itfusen.domain.entity.user;

import com.itfusen.domain.comm.BaseEntity;

public class Permission extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String url;
	private String name;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}