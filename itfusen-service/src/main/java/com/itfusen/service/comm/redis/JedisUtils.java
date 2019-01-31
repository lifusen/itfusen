package com.itfusen.service.comm.redis;
import java.util.List;

import javax.annotation.Resource;

import redis.clients.jedis.JedisCluster;

/**
 * Created by tom on 2018/10/13.
 */

public class JedisUtils {

    @Resource
    private JedisCluster jedisCluster;

    private static final String SET_ONLY = "NX";//Only set the key
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    public String set(String key,String value,int expire)
    {
        return jedisCluster.setex(key,expire,value);
    }
    public String set(String key,String value)
    {
        return jedisCluster.set(key,value);
    }
    public String set(String key,int value,int expire)
    {
        return jedisCluster.setex(key,expire,Integer.toString(value));
    }
    public String set(String key,int value)
    {
        return jedisCluster.set(key,Integer.toString(value));
    }
    public void set(String key, List<String> value, int expire)
    {
       // jedisCluster.lpushx()
        //jedisCluster.lrange()
        jedisCluster.setex(key,expire,"");
        jedisCluster.lrem(key,1,"");
        for(String item:value)
        {
            jedisCluster.lpush(key,item);
        }
    }
    public void set(String key,List<String> value)
    {
        jedisCluster.set(key,"");
        jedisCluster.lrem(key,1,"");
        for(String item:value)
        {
            jedisCluster.lpush(key,item);
        }
    }
    public String get(String key)
    {
        return jedisCluster.get(key);
    }
    public List<String> getList(String key)
    {
        return jedisCluster.lrange(key,0, -1);
    }
    public boolean exists(String key)
    {
        return jedisCluster.exists(key);
    }
    public long ttl(String key)
    {
        return jedisCluster.ttl(key);
    }
    public Long expire(String key, int time)
    {
        return jedisCluster.expire(key,time);
    }
    public Long del(String key)
    {
        return jedisCluster.del(key);
    }
}
