package com.itfusen.service.comm.rabbitMQ;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

	    //private Logger logger = LoggerFactory.getLogger(MessageProducer.class);  

	    @Resource(name="amqpTemplate")  
	    private AmqpTemplate amqpTemplate;  

	    @Resource(name="amqpTemplate2")  
	    private AmqpTemplate amqpTemplate2;  

	    public void sendMessage(Object message) throws IOException {  
	        //logger.info("to send message:{}", message);  
	        System.out.println("to send message:{}"+ message);
	        amqpTemplate.convertAndSend("queueTestKey", message);  
	        amqpTemplate.convertAndSend("queueTestChris", message);  
	        amqpTemplate2.convertAndSend("shijj.xxxx.wsdwd", message);  
	    }  
	}
