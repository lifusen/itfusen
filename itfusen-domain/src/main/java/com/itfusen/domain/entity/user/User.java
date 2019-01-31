package com.itfusen.domain.entity.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.AuthorizationInfo;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itfusen.domain.comm.BaseEntity;

public class User extends BaseEntity implements AuthorizationInfo{

	private static final long serialVersionUID = 1L;
	private String name;
	private String loginName;
	private String loginPwd;
	private Date createTime;
	private Date lastLoginTime;
	private String phone;
	private String sex;
	private int status;
	private Collection<String> roles;
	private Set<Role> setRoles;
	private Set<Permission> permissions;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Collection<String> getRoles() {
		return roles;
	}
	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}
	public Set<Role> getSetRoles() {
		return setRoles;
	}
	public void setSetRoles(Set<Role> setRoles) {
		this.setRoles = setRoles;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	//当原生的授权无法满足额外属性时
    public Collection<String> getStringPermissions()
    {
        List<String> strPermissions = new ArrayList<>();
        if(this.permissions != null)
        {
            for(Permission item:this.permissions)
            {
                String permission = item.getUrl();
                strPermissions.add(permission);
            }
        }
        return strPermissions;
    }
	@Override
	public Collection<org.apache.shiro.authz.Permission> getObjectPermissions() {
		// TODO Auto-generated method stub
		return null;
	}
}
