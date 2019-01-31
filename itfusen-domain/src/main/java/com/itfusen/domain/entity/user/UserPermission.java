package com.itfusen.domain.entity.user;

import com.itfusen.domain.comm.BaseEntity;

public class UserPermission extends BaseEntity{
	private static final long serialVersionUID = 1L;

    private Long uid;

    private Long pid;

    public UserPermission(Long uid,Long pid) {
    	this.uid = uid;
    	this.pid = pid;
	}
    public UserPermission() {
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}

}