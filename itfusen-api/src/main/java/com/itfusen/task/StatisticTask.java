package com.itfusen.task;

import com.itfusen.comm.util.DateUtils;

/**
 *author lifusen
 *date 2018年10月31日
 *description Task测试运行
 */
public class StatisticTask {

    public void handle() throws InterruptedException
    {
        System.out.println("Task1运行10S一次...:"+DateUtils.format(DateUtils.getNowDate()));
    }

}
