package com.down.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * @author lh
 * @description
 * @date 2017年6月9日 下午2:26:57
 * @email ahlxlihao@163.com
 * 
 */
public final class RabbitMQConsumerTest {
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

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
						byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
					System.out.println("Received Message << '" + message + "'");
					isBreak = true;
				}
			};

			channel.basicConsume(QUEUE_NAME, true, consumer);

			while (!isBreak) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			channel.close();
			connection.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
