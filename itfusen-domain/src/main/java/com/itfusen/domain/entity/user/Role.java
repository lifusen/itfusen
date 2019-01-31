package com.itfusen.domain.entity.user;

import java.util.HashSet;
import java.util.Set;

import com.itfusen.domain.comm.BaseEntity;

public class Role extends BaseEntity{
	private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    private Set<Permission> permissions = new HashSet<Permission>();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public void setType(String type) {
        this.type = type;
    }

}