package com.accolite.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accolite.amqp.RabbitMqMessageProducer;
import com.accolite.clients.fraud.FraudClient;
import com.accolite.clients.fraud.FraudResponse;
import com.accolite.clients.notification.NotificationClient;
import com.accolite.clients.notification.NotificationRequest;
import com.netflix.discovery.converters.Auto;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private FraudClient fraudClient;
	//@Autowired
	//private NotificationClient notificationClient;
	@Autowired
	private RabbitMqMessageProducer producer;

	public void registerCustomer(CustomerRegistrationRequest request) {
		// TODO Auto-generated method stub
		Customer customer=Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email())
				.build();
		
		//TODO- check if email is valid, check if email is not taken, store customer in db
		
		customerRepo.saveAndFlush(customer); //saves and clears off.. has the customer ID instead of null so that we can check for fraudster
		
		//TODO- check if fraudster, send notification
		
		/*FraudResponse fraudResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}", 
				FraudResponse.class, 
				customer.getId());*/
		
		/*FraudResponse fraudResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", 
				FraudResponse.class, 
				customer.getId());*/
		
		FraudResponse fraudResponse = fraudClient.isFraudster(customer.getId());
		
		if(fraudResponse.isFraudster()) {
			throw new IllegalStateException("fraudster");
		}
		
		
		//send notification
		/*
		notificationClient.sendNotification(
				new NotificationRequest(customer.getId(), 
						customer.getEmail(), 
						String.format("Hi %s welcome to microservices", customer.getFirstName()))
				);*/
		
		
		//making it async- sending it to the queue
		
		NotificationRequest notificationRequest = new NotificationRequest(customer.getId(), 
				customer.getEmail(), 
				String.format("Hi %s welcome to microservices", customer.getFirstName()));
		producer.publishMessage(notificationRequest, "internal.exchange", "internal.notification.routing-key");
		
	}

}
