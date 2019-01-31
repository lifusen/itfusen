package com.itfusen.task;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.itfusen.comm.util.DateUtils;
import com.itfusen.service.comm.rabbitMQ.MessageProducer;

/**
 *author lifusen
 *date 2018年10月31日
 *description Task测试运行
 */
public class StatisticTask2 {

	@Autowired
	MessageProducer messageProducer;
	
    public void handle() throws InterruptedException
    {
        System.out.println("Task2运行55S一次...:"+DateUtils.format(DateUtils.getNowDate()));
        try {
			messageProducer.sendMessage("Task发送消息: rabbitMQ 666666");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
