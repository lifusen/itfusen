package com.itfusen.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itfusen.comm.SystemConfig;
import com.itfusen.comm.util.DateUtils;
import com.itfusen.dao.user.UserDao;
import com.itfusen.domain.comm.BaseStatusConfig;
import com.itfusen.domain.entity.user.User;
import com.itfusen.domain.enums.ResponseEnum;
import com.itfusen.domain.exception.ResponseException;
import com.itfusen.service.comm.redis.SLLockManager;
import com.itfusen.service.comm.shiro.util.ShiroUtils;
import com.itfusen.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
    private SLLockManager slLockManager;
	
	@Override
	public List<User> queryByField(User object) {
		return null;
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	//用户注册-事务-锁
	@Transactional
	@Override
	public int insert(User object) 
	{
		int result = 0;
		try 
		{
			slLockManager.lockUserInsert.tryLock();
			object.setCreateTime(DateUtils.getNowDate());
			object.setStatus(BaseStatusConfig.UserStatusConfig.USER_NORMAL);
			String cryptographicPwd = ShiroUtils.sha256(object.getLoginPwd(), SystemConfig.salt);
			object.setLoginPwd(cryptographicPwd);
			result = userDao.insert(object);
			if(result<1){
				throw new ResponseException(ResponseEnum.USER_INSERT_ERROR);
			}
			slLockManager.lockUserInsert.unlock();
		}catch(Exception e)
		{
			slLockManager.lockUserInsert.unlock();
		}
		return result;
	}

	@Override
	public int update(User object) {
		return userDao.update(object);
	}

	@Override
	public int delete(Long id) {
		return 0;
	}

	@Override
	public User login(User user) {	
		User u = userDao.login(user);
		if(u==null)
		{
			throw new ResponseException(ResponseEnum.USER_LOGIN_ERROR);
		}
		return u;
	}

	@Override
	public User queryInfoByLoginName(String loginName) {
		return userDao.queryInfoByLoginName(loginName);
	}

	@Override
	public User queryById(Long id) {
		return userDao.queryByLongId(id);
	}

}
