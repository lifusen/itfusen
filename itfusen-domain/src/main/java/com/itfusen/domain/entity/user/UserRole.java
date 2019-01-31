package com.itfusen.domain.entity.user;

import com.itfusen.domain.comm.BaseEntity;

public class UserRole extends BaseEntity{
	private static final long serialVersionUID = 1L;

    private Long uid;

    private Long rid;

    public UserRole(Long uid,Long rid) {
    	this.uid = uid;
    	this.rid = rid;
	}
    public UserRole() {
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}