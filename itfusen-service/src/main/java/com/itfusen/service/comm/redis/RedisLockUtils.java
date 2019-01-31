package com.itfusen.service.comm.redis;

import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Random;
/**
 * Created by tom on 2018/10/13.
 */
public class RedisLockUtils {
    private static final Long RELEASE_SUCCESS = 1L;
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    @Resource
    private JedisCluster jedisCluster;

    /**
     * 添加分布式锁
     * @param lockKey 锁key
     * @param lockId 锁标识
     * @param expireMillis 锁的实效时间，单位ms
     * @return Boolean true--加锁成功，false--加锁失败
     */
    public boolean distributeLock(String lockKey, String lockId, Long expireMillis) {
        boolean flag = false;
        try {
            String result = jedisCluster.set(lockKey, lockId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireMillis);
            if (LOCK_SUCCESS.equals(result)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 释放分布式锁
     * @param lockKey 锁key
     * @param lockId  锁标识
     * @return boolean  true--释放锁成功，false--释放锁失败
     */
    public boolean distributeUnlock(String lockKey, String lockId) {
        boolean flag = false;
        try {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result = jedisCluster.eval(script, Collections.singletonList(lockKey), Collections.singletonList(lockId));
            if (RELEASE_SUCCESS.equals(result)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
    }

    /**
     * 锁重试的间隔时长，这个随机值可以根据一个事务的处理时长来设置，这里默认写的是0~100的随机数
     * @return
     */
    public  long getRetryTime(){
        Random random = new Random(100);
        return random.nextLong();
    }
}
