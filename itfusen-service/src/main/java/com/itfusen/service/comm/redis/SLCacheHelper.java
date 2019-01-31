package com.itfusen.service.comm.redis;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.itfusen.comm.util.LogHelper;

/**
 * Created by tom on 2018/10/13.
 */
public class SLCacheHelper {
    @Autowired
    private SLCacheManager slCacheManager;

    private static final Logger logger= LogHelper.cache_logger;
    public static Lock lock_unprocessed_scan_log_count = new ReentrantLock();
    public static Lock lock_unprocessed_convert_item_count = new ReentrantLock();
    public static Lock lock_unprocessed_mdmsync_item_count = new ReentrantLock();
    public static Lock lock_unprocessed_kpsync_item_count = new ReentrantLock();
    public static Lock lock_unprocessed_pushorder_item_count = new ReentrantLock();


    public  int getUnProcessedScanLogCount()
    {
        return getCacheValue(SLCacheManager.UNPROCESSED_SCAN_LOG_COUNT);

    }
    public  void addUnProcessedScanLogCount(int count)
    {
        addCache(lock_unprocessed_scan_log_count,SLCacheManager.UNPROCESSED_SCAN_LOG_COUNT,count);
    }

    public  int getUnProcessedConvertItemCount()
    {
        return getCacheValue(SLCacheManager.UNPROCESSED_CONVERT_ITEM_COUNT);
    }
    public  void addUnProcessedConvertItemCount(int count)
    {
        addCache(lock_unprocessed_convert_item_count,SLCacheManager.UNPROCESSED_CONVERT_ITEM_COUNT,count);
    }

    public  int getUnProcessedMdmSyncItemCount()
    {
        return getCacheValue(SLCacheManager.UNPROCESSED_MDMSYNC_ITEM_COUNT);
    }
    public  void addUnProcessedMdmSyncItemCount(int count)
    {
        addCache(lock_unprocessed_mdmsync_item_count,SLCacheManager.UNPROCESSED_MDMSYNC_ITEM_COUNT,count);
    }

    public  int getUnProcessedMdmSyncDistributorItemCount()
    {
        return getCacheValue(SLCacheManager.UNPROCESSED_MDMSYNC_DISTRIBUTOR_ITEM_COUNT);
    }
    public  int getUnProcessedKPSyncDistributorItemCount()
    {
        return getCacheValue(SLCacheManager.UNPROCESSED_KPSYNC_DISTRIBUTOR_ITEM_COUNT);
    }
    public  void addUnProcessedMdmSyncDistributorItemCount(int count)
    {
        addCache(lock_unprocessed_mdmsync_item_count,SLCacheManager.UNPROCESSED_MDMSYNC_DISTRIBUTOR_ITEM_COUNT,count);
    }
    public  void addUnProcessedKPSyncDistributorItemCount(int count)
    {
        addCache(lock_unprocessed_kpsync_item_count,SLCacheManager.UNPROCESSED_KPSYNC_DISTRIBUTOR_ITEM_COUNT,count);
    }

    //推送订单到要货系统
    public  int getUnProcessedPushorderItemCount()
    {
        return getCacheValue(SLCacheManager.UNPROCESSED_PUSHORDER_ITEM_COUNT);
    }
    public  void addUnProcessedPushorderItemCount(int count)
    {
        addCache(lock_unprocessed_pushorder_item_count,SLCacheManager.UNPROCESSED_PUSHORDER_ITEM_COUNT,count);
    }

    public  int getCacheValue(String key)
    {
        if (slCacheManager.isExist(key)) {
            return slCacheManager.getInt(key);
        }else{
            return 0;
        }
    }
    public  void addCache(Lock lock,String key,int count)
    {
        lock.lock();
        try
        {
            if (slCacheManager.isExist(key)) {
                int existValue = slCacheManager.getInt(key);
                existValue += count;
                slCacheManager.setValue(key,existValue);
            }else{
                slCacheManager.setValue(key,1);
            }
        }catch (Exception e)
        {
            lock.unlock();
            logger.error("addCache key: "+key+" count: "+count+" failed:"+e.getMessage());
            return;
        }
        lock.unlock();
    }
}
