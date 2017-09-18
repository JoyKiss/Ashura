package com.down.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import net.sf.json.JSONObject;

public class MQtest {

	public static void main(String[] args) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("zhongtai");
		factory.setPassword("zhongtai2017");
		factory.setHost("10.29.180.87");
		factory.setVirtualHost("/");
		factory.setPort(5672);
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();
		channel.queueDeclare("TOE_TOP_FMC_QUEUE", true, false, false, null);
		JSONObject json = JSONObject.fromObject("5555555555");
		// 第二， 我们需要标识我们的信息为持久化的。通过设置MessageProperties（implements
		// BasicProperties）值为PERSISTENT_TEXT_PLAIN。
		// channel.basicPublish("",
		// "task_queue",MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
		channel.basicPublish("", "TOE_TOP_FMC_QUEUE", MessageProperties.PERSISTENT_TEXT_PLAIN,
				json.toString().getBytes());
		channel.close();
	}
}
