package com.itfusen.dao.user;

import java.util.Collection;
import java.util.Set;

import com.itfusen.dao.comm.BaseDao;
import com.itfusen.domain.entity.user.Role;

public interface RoleDao extends BaseDao<Role>{

	Set<Role> queryRolesByUserId(Long userId);
	Collection<String> queryStrRolesByUserId(Long userId);
}
