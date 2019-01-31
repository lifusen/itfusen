package com.itfusen.service.comm.rabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MessageConsumer implements MessageListener{
	
	//private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);  
    
	@Override
    public void onMessage(Message message) {
        // logger.info("consumer receive message------->:{}", message);  
        System.out.println("consumer receive message------->:{}"+ message);
    }

}
