package com.itfusen.api.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itfusen.api.comm.BaseAction;
import com.itfusen.domain.dto.ResponseResult;
import com.itfusen.domain.entity.user.User;
import com.itfusen.domain.enums.ResponseEnum;
import com.itfusen.domain.exception.ResponseException;
import com.itfusen.service.sysconfig.SysLog;
import com.itfusen.service.user.UserService;
import com.itfusen.comm.util.LogHelper;

/**
 *author lifusen
 *date 2018年10月29日
 *description UserAction
 */
@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction<User,UserService>{

	private static final Logger user_logger= LogHelper.user_logger;
	
	@Autowired
	private UserService userService;
	
	/**
	 *author lifusen
	 *date 2018年10月29日
	 *description 新增
	 */
	@SysLog
	@ResponseBody
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ResponseResult adduser(@RequestBody User user){
		ResponseResult result = null;
		List<User> list = new ArrayList<>();
		list.add(user);
		try{
			this.operation(list, 1, userService, user_logger);
			result = new ResponseResult(ResponseEnum.SUCCESS, user);
		}catch(ResponseException e)
		{
			result = new ResponseResult(e.getErrorEnum());
		}catch(Exception e)
		{
			result = new ResponseResult(ResponseEnum.FAILED);
		}
        return result;
	}
}
