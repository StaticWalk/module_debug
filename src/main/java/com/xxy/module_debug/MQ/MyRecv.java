package com.xxy.module_debug.MQ;

import com.xxy.module_debug.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;




/**
 * Created by xiongxiaoyu
 * Data:2019/5/31
 * Time:10:02
 */

@Component
public class MyRecv {

	Logger logger = LoggerFactory.getLogger(MyRecv.class);

	//1. @RabbitListener(queues = "myQueue")
	//2. 自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
	//3. 自动创建, Exchange和Queue绑定
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue("myQueue"),
		//	key = "computer",//路由，第二个参数传入
			exchange = @Exchange("myExchange")
	))
	public void process(String message) {
		logger.info("MqReceiver: {}", message);
	}


	@RabbitListener(queuesToDeclare = @Queue("date") )
	public void processDate(String date) {
		logger.info("Receiver ==================: " + date);
	}


	@RabbitListener(queuesToDeclare = @Queue("object") )
	public void processObj(User user) {
		logger.info("Receiver ==================: " + user);
		logger.info("Receiver ==================: " + user.getUsername());
		logger.info("Receiver ==================: " + user.getAge());
	}

}
