package com.xxy.module_debug.MQ;

import com.xxy.module_debug.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by xiongxiaoyu
 * Data:2019/5/31
 * Time:10:23
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyRecvTest {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void processDate() {
		amqpTemplate.convertAndSend("date","时间"+new Date());
	}

	@Test
	public void processObj() {
		amqpTemplate.convertAndSend("object",new User("22","小行星","66","88"));
	}
}