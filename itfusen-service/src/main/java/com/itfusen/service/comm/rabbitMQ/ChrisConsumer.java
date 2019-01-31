package com.itfusen.service.comm.rabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ChrisConsumer implements MessageListener{
	
	// private Logger logger = LoggerFactory.getLogger(ChrisConsumer.class);  
	    @Override  
	    public void onMessage(Message message) {  
	       // logger.info("chris receive message------->:{}", message); 
	        System.out.println("chris receive message------->:{}"+ message);
	    }  


}
