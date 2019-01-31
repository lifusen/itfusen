package com.itfusen.service.user;

import com.itfusen.domain.entity.user.User;
import com.itfusen.service.comm.BaseService;

public interface UserService extends BaseService<User>{

	User login(User user);
	User queryInfoByLoginName(String loginName);
}
