package com.itfusen.service.comm.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.itfusen.domain.entity.user.User;

/**
 * Shiro Util
 * 
 * @author Joy.Wei
 */
public class ShiroUtils {
	/**  encryption method */
	public final static String hashAlgorithmName = "MD5";
	/**  loop time */
	public final static int hashIterations = 1;

	public static String sha256(String password, String salt) {
		return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
	}

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static Object getManagerEntity() throws Exception {
		return SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
	}

	public static User getUserEntity() {
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		return user;
	}

	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}

//	public static CheckAppUser getCheckAppUserEntity() {
//		 CheckAppUser checkAppuser = (CheckAppUser)SecurityUtils.getSubject().getPrincipal();
//		return checkAppuser;
//	}
/*
	public static String getKaptcha(String key) {
		Object kaptcha = getSessionAttribute(key);
		if(kaptcha == null){
			throw new RRException("vefiry code expired");
		}
		getSession().removeAttribute(key);
		return kaptcha.toString();
	}*/

}
