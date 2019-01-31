package com.itfusen.service.comm.shiro.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import com.itfusen.domain.entity.user.User;

/**
 * Created by lifusen on 2018/10/13 19:29
 */
public class EasyTypeMatcher extends HashedCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        User user = (User) info.getPrincipals().getPrimaryPrincipal();
//        System.out.println(user);
//        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
//        String a = (String)session.getAttribute("a");
//        if(a.equals("a")){
//            return true;
//        }
        return super.doCredentialsMatch(token, info);
    }
}
