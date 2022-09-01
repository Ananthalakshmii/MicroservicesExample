package com.accolite.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RabbitMqMessageProducer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void publishMessage(Object payload,String exchange,String routingKey) {
		log.info(" publishing to {} using routing key {}. payload {} ",exchange,routingKey,payload);
		amqpTemplate.convertAndSend(exchange, routingKey, payload);
		log.info(" published to {} using routing key {}. payload {} ",exchange,routingKey,payload);
	}

}
