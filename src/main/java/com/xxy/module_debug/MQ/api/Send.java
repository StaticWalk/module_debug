package com.xxy.module_debug.MQ.api;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeoutException;

/**
 * Created by xiongxiaoyu
 * Data:2019/5/31
 * Time:9:22
 */
public class Send {

	//队列名称
	private final static String QUEUE_NAME = "helloMQ";

	public static void main(String[] argv) throws java.io.IOException, TimeoutException
	{
		/**
		 * 创建连接连接到MabbitMQ
		 */
		ConnectionFactory factory = new ConnectionFactory();
		//设置MabbitMQ所在主机ip或者主机名
		factory.setHost("118.89.36.125");
		//创建一个连接
		Connection connection = factory.newConnection();
		//创建一个频道
		Channel channel = connection.createChannel();
		//指定一个队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//发送的消息
		String message = "hello world!";
		//往队列中发出一条消息
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		//关闭频道和连接
		channel.close();
		connection.close();
	}
}
