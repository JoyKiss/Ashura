package com.down.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author lh
 * @description
 * @date 2017年6月9日 下午2:26:57
 * @email ahlxlihao@163.com
 * 
 */
public final class RabbitMQPublishTest {
	private final static String QUEUE_NAME = "TOE_TOP_FMC_QUEUE";
	static boolean isBreak = false;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("zhongtai");
		factory.setPassword("zhongtai2017");
		factory.setHost("10.29.180.87");
		factory.setVirtualHost("/");
		factory.setPort(5672);

		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
			for (int i = 0; i < 5; i++) {
				String message = "Hello World!" + i;
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
				System.out.println("Sent Message >> " + message);
			}

			channel.close();
			connection.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

}