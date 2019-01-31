package com.itfusen.service.comm.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SLLockManager {
	
	public  SLLock lockUserInsert;
    @Autowired
    public  SLLock processMDMSyncDistributorLog;
    @Autowired
    public  SLLock processMDMSyncLog;
    @Autowired
    public  SLLock loadingStoreId;
    @Autowired
    public  SLLock checkingStoreWillScore;
    @Autowired
    public  SLLock backgroundPushOrderToYaohuoTask;
    @Autowired
    public  SLLock backgroundSummaryConvertItemTask;
    @Autowired
    public  SLLock loadingStoreIdByUserID;
    @Autowired
    public  SLLock processKPSyncDistributorLog ;
    @Autowired
    public  SLLock checkScanedBottle;
    @Autowired
    public  SLLock backgroundSummaryScanLogTask;
    @Autowired
    public  SLLock deductStoreScoreLock;
    @PostConstruct
    public  void  init()
    {
        /*
        processMDMSyncDistributorLog = new SLLock("processMDMSyncDistributorLog");
        processMDMSyncLog = new SLLock("processMDMSyncLog");
        loadingStoreId = new SLLock("loadingStoreId");
        checkingStoreWillScore = new SLLock("checkingStoreWillScore");
        backgroundPushOrderToYaohuoTask = new SLLock("backgroundPushOrderToYaohuoTask");
        backgroundSummaryConvertItemTask = new SLLock("backgroundSummaryConvertItemTask");
        loadingStoreIdByUserID = new SLLock("loadingStoreIdByUserID");
        processKPSyncDistributorLog = new SLLock("processKPSyncDistributorLog");
        checkScanedBottle = new SLLock("checkScanedBottle");
        backgroundSummaryScanLogTask = new SLLock("backgroundSummaryScanLogTask");
        deductStoreScoreLock = new SLLock("deductStoreScoreLock");
        */
    }
}
