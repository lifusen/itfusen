package com.itfusen.api.login;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
import com.itfusen.service.comm.shiro.util.ShiroUtils;
import com.itfusen.service.sysconfig.SysLog;
import com.itfusen.service.user.UserService;

/**
 *author lifusen
 *date 2018年10月29日
 *description LoginAction
 */
@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("/auth")
public class LoginAction extends BaseAction{

	@Autowired
	private UserService userService;
	
	/**
	 *author lifusen
	 *date 2018年10月29日
	 *description 登陆
	 */
	@SysLog
	@ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseResult login(@RequestBody User user){
		ResponseResult result = null;
		try{
			Subject subject = ShiroUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getLoginPwd());
			subject.login(token);
			User currentUser = userService.queryById(ShiroUtils.getUserEntity().getId());
			result = new ResponseResult(ResponseEnum.SUCCESS, currentUser);
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
