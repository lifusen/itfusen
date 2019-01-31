package com.itfusen.dao.user;

import com.itfusen.dao.comm.BaseDao;
import com.itfusen.domain.entity.user.User;

public interface UserDao extends BaseDao<User>{

	User login(User user);
	User queryInfoByLoginName(String loginName);
}
