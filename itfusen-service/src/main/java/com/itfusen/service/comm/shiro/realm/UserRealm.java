package com.itfusen.service.comm.shiro.realm;


import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itfusen.comm.SystemConfig;
import com.itfusen.dao.user.RoleDao;
import com.itfusen.dao.user.UserDao;
import com.itfusen.domain.entity.user.Permission;
import com.itfusen.domain.entity.user.Role;
import com.itfusen.domain.entity.user.User;
import com.itfusen.service.comm.shiro.matcher.EasyTypeMatcher;
import com.itfusen.service.comm.shiro.util.ShiroUtils;

/**
 *author lifusen
 *date 2018年10月29日
 *description shiroRealm
 */
@Component
public class UserRealm extends AuthorizingRealm {
    
	@Autowired
    private UserDao userDao;
	
	@Autowired
    private RoleDao roleDao;

	//注意原生和自定义的区别
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) 
	{

        User user = userDao.queryByLongId(ShiroUtils.getUserEntity().getId());
        user.setRoles(roleDao.queryStrRolesByUserId(user.getId()));
        user.setSetRoles(roleDao.queryRolesByUserId(user.getId()));
        //SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //add role and permissions
        if(user !=null && user.getSetRoles() !=null)
        {
            //info.addRole(role.getName());
        	Set<Permission> permsSet = new HashSet<>();
        	for(Role role:user.getSetRoles())
        	{
        		for(Permission permission:role.getPermissions())
        		{
        			permsSet.add(permission);
        		}
        	}
        	//info.addStringPermissions(permsSet);
        	user.setPermissions(permsSet);
        }
		return user;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException 
	{
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;

        //query user Information
        User user = userDao.queryInfoByLoginName(token.getUsername());

        //account not exsit
        if(user == null) {
            throw new UnknownAccountException("username or password error");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLoginPwd(), ByteSource.Util.bytes(SystemConfig.salt), getName());
        return info;
	}

	//自定义的matcher,为了处理免密码登陆
    @Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) 
    {
		EasyTypeMatcher shaCredentialsMatcher = new EasyTypeMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}

    public static void main(String[] args) 
    {
        String hashAlgorithmName = "MD5";
        String credentials = "123456";
        int hashIterations = 1;
        Object obj = new SimpleHash(hashAlgorithmName, credentials, SystemConfig.salt, hashIterations);
        System.out.println(obj);
    }
}
