package com.accolite.notification.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accolite.clients.notification.NotificationRequest;
import com.accolite.notification.NotificationService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificationConsumer {
	@Autowired
	private NotificationService notificationService;
	
	@RabbitListener(queues = "${rabbitmq.queue.notification}")
	public void consume(NotificationRequest notificationRequest) {
		log.info("Consumed {} from queue ", notificationRequest);
		notificationService.sendNotification(notificationRequest);
	}

}
