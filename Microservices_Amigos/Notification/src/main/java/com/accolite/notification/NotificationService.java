package com.accolite.notification;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.clients.notification.NotificationRequest;

@Service
public class NotificationService {
	@Autowired
	private NotificationRepo notificationRepo;

	public void sendNotification(NotificationRequest notificationRequest) {
		Notification notification=Notification.builder()
									.toCustomerId(notificationRequest.toCustomerId())
									.sender(notificationRequest.toCustomerName())
									.message(notificationRequest.message())
									.sentAt(LocalDateTime.now())
									.toCustomerEmail(notificationRequest.toCustomerName())
									.build();
				
		notificationRepo.save(notification);
	}
	

}
