package com.itfusen.service.comm.shiro.session;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
/**
 * Created by tom on 2018/10/13.
 */
public class ShiroSessionFactory  implements SessionFactory{
    @Override
    public Session createSession(SessionContext initData) {
        ShiroSession session = new ShiroSession();
        return session;
    }
}
