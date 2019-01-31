package com.itfusen.domain.comm;

import java.io.Serializable;

/**
 *author lifusen
 *date 2018年10月29日
 *description 自增ID、序列化
 */
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
