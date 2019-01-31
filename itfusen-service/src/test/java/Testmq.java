

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itfusen.service.comm.rabbitMQ.MessageProducer;


public class Testmq {

   //private Logger logger = LoggerFactory.getLogger(Testmq.class);  
  
    private ApplicationContext context = null;  
  
//    @Before
//    public void setUp() throws Exception {  
//        context = new ClassPathXmlApplicationContext("application.xml");  
//    }  
//  
//    @Test  
//    public void should_send_a_amq_message() throws Exception {  
//        MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");  
//        int a = 100;  
//        while (a > 0) {  
//            messageProducer.sendMessage("Hello, I am amq sender num :" + a--);  
//            try {  
//                //暂停一下，好让消息消费者去取消息打印出来  
//                Thread.sleep(1000);  
//            } catch (InterruptedException e) {  
//                e.printStackTrace();  
//            }  
//  
//        }  

    public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");  
   	 MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");  
        int a = 100;  
        while (a > 0) {  
            try {
				messageProducer.sendMessage("Hello, I am amq sender num :" + a--);
			} catch (IOException e1) {
				e1.printStackTrace();
			}  
            try {  
                //暂停一下，好让消息消费者去取消息打印出来  
                Thread.sleep(50000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
  
        } 
	}
    
}