package com.accolite.notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class NotificationConfig {
	@Value("${rabbitmq.exchange.internal}")
	private String internalExchange;
	@Value("${rabbitmq.queue.notification}")
	private String notificationQueue;
	@Value("${rabbitmq.routing-key.internal-notification}")
	private String internalNotificationRoutingKey;
	
	@Bean //retrieving topic exchange
	public TopicExchange internalTopicExchange() {
		return new TopicExchange(this.internalExchange);
	}
	
	@Bean//retrieve queue
	public Queue notificationQueue() {
		return new Queue(this.notificationQueue);
	}
	
	@Bean //binding queue with exchange with routing key
	public Binding exchangeToQueueBinding() {
		return BindingBuilder.bind(notificationQueue())
				.to(internalTopicExchange())
				.with(this.internalNotificationRoutingKey);
	}

}
