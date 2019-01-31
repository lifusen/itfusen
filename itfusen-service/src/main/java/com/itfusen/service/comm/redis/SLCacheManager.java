package com.itfusen.service.comm.redis;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by tom on 2018/10/13.
 */
public class SLCacheManager {
    @Autowired
    private JedisUtils jedisUtils;

    public static final String INSERT_STORE_ID_PREFIX = "insert_store_id_prefix";
    public static final String INSERT_USER_ID_PREFIX = "insert_user_id_prefix";
    public static final String STORE_ID_PREFIX = "store_id_prefix";
    public static final String PRODUCT_SCORE_PREFIX = "product_score_prefix";
    public static final String STORE_WILL_SCORE_PREFIX = "store_will_score_prefix";
    public static final String STORE_ACTIVE_SCORE_PREFIX = "store_will_active_prefix";
    public static final String STORE_TOTAL_WILL_SCORE_PREFIX = "store_total_will_score_prefix";
    public static final String STORE_TOTAL_ACTIVE_SCORE_PREFIX = "store_total_will_active_prefix";
    public static final String BOTTLE_CODE_PREFIX = "bottle_code_prefix";
    public static final String YAOHUO_DISTRIBUTOR_ID_PREFIX = "yaohuo_distributor_id_prefix";
    public static final String UNPROCESSED_SCAN_LOG_COUNT = "unprocessed_scan_log_count";
    public static final String UNPROCESSED_CONVERT_ITEM_COUNT = "unprocessed_convert_item_count";
    public static final String UNPROCESSED_MDMSYNC_ITEM_COUNT = "unprocessed_mdmsync_item_count";
    public static final String UNPROCESSED_PUSHORDER_ITEM_COUNT = "unprocessed_pushorder_item_count";
    public static final String UNPROCESSED_MDMSYNC_DISTRIBUTOR_ITEM_COUNT = "unprocessed_mdmsync_distributor_item_count";
    public static final String UNPROCESSED_KPSYNC_DISTRIBUTOR_ITEM_COUNT = "unprocessed_kpsync_distributor_item_count";
    public static final String STORE_SCORE_PREFIX = "store_score_prefix";
    public static final String STORE_SCORE_LASTYEAR_PREFIX = "store_score_lastyear_prefix";
    public static final String PROVINCE_CITY_AREA = "province_city_area";
    public  void setValue(String key, String value, int second)
    {
        jedisUtils.set(key,value,second);
    }
    public  void setValue(String key, String value)
    {
        jedisUtils.set(key,value);
    }

    public  void setValue(String key, int value, int second)
    {
        jedisUtils.set(key,value,second);
    }
    public  void setValue(String key, int value )
    {

        jedisUtils.set(key,value);
    }

    public  void setValue(String key, BigInteger value, int second)
    {
        jedisUtils.set(key,value.intValue(),second);
    }
    public  void setValue(String key, BigInteger value )
    {
        jedisUtils.set(key,value.intValue());
    }

    public  void setValue(String key, List<String> value )
    {
        jedisUtils.set(key,value);
    }

    public  void setValue(String key, float value, int second)
    {
        jedisUtils.set(key,Float.toString(value),second);
    }
    public  void setValue(String key, float value )
    {
        jedisUtils.set(key,Float.toString(value));
    }

    public  boolean isExist(String key)
    {
        return jedisUtils.exists(key);
    }

    public   String getString(String key)
    {
        return  jedisUtils.get(key);
    }
    public  int getInt(String key)
    {
        String v = jedisUtils.get(key);
        return  Integer.parseInt(v);
    }
    public   float getFloat(String key)
    {
        String v = jedisUtils.get(key);
        return  Float.parseFloat(v);
    }
    public   BigInteger getBigInteger(String key)
    {
        String v = jedisUtils.get(key);
        return  new BigInteger(v);
    }
    public   List<String> getList(String key)
    {
        return  jedisUtils.getList(key);
    }

    public  void delete(String key)
    {
        jedisUtils.del(key);
    }
}
