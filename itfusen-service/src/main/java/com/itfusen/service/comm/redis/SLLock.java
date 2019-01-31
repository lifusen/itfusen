package com.itfusen.service.comm.redis;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tom on 2018/10/14.
 */
public class SLLock {

    private static final String prefix = "SLLock_";
    @Autowired
    private RedisLockUtils redisLockUtils;

    private  String lockThreadSafeIdenfer;
    private  String lockName;
    private  Long expireMillis = 500L;
    public  SLLock(String name)
    {
        lockName = name;
        lockThreadSafeIdenfer = UUID.randomUUID().toString();
    }
    public SLLock(String name,Long expire)
    {
        lockName = name;
        expireMillis = expire;
        lockThreadSafeIdenfer = UUID.randomUUID().toString();
    }
    public boolean tryLock()
    {
        boolean isLock = false;
        for (int retryNum=0; retryNum<3; retryNum++){
            isLock = redisLockUtils.distributeLock(prefix+lockName,lockThreadSafeIdenfer,expireMillis);
            if(isLock == true){
                break;
            }
            //如果获取锁失败，等待一会儿再去获取锁，重试三次，三次都失败了，就认为本次处理失败
            try {
                Thread.sleep(redisLockUtils.getRetryTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return isLock;
    }
    public boolean unlock()
    {
        boolean isUnlock = redisLockUtils.distributeUnlock(prefix+lockName,lockThreadSafeIdenfer);
        return isUnlock;
    }
}
