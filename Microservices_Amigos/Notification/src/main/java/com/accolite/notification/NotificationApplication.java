package com.accolite.notification;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.accolite.amqp.RabbitMqMessageProducer;

@SpringBootApplication(scanBasePackages = {"com.accolite.amqp", "com.accolite.notification"})
@EnableFeignClients(basePackages = "com.accolite.clients")
@EnableEurekaClient
public class NotificationApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}
	
	
	/*
	@Bean
	CommandLineRunner commandLineRunner(RabbitMqMessageProducer producer, NotificationConfig config) {
	//	return args->{
	//		producer.publishMessage("foo", config.getInternalExchange(), config.getInternalNotificationRoutingKey());
	//	};
		return args->{
			producer.publishMessage(new Person("Ali", 18), config.getInternalExchange(), config.getInternalNotificationRoutingKey());
		};
	}
	
	record Person(String name,Integer age) {}
	
	*/

}
