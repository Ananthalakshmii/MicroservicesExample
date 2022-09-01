package com.accolite.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.clients.notification.NotificationClient;
import com.accolite.clients.notification.NotificationRequest;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping
	public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
		log.info("new notification.. {} ",notificationRequest);
		notificationService.sendNotification(notificationRequest);
	}

}
