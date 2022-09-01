package com.accolite.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	@Autowired
	private ConnectionFactory connectionFactory;
	
	//used to send messages to the queue--publish
	@Bean
	public AmqpTemplate amqpTemplate() {
		RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}
	
	
	//used to listen to the messages from the queue--listener
	@Bean
	public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory=new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(messageConverter());
		return factory;
	}
	
	@Bean
	public MessageConverter messageConverter() {
		MessageConverter messageConverter=new Jackson2JsonMessageConverter();
		return messageConverter;
		
	}

}