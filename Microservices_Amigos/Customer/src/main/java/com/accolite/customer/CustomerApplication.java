package com.accolite.customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.accolite.customer","com.accolite.amqp"})
@EnableEurekaClient
@EnableFeignClients(
		basePackages = "com.accolite.clients"
		)
public class CustomerApplication {
	public static void main(String[] args) {
		
		SpringApplication.run(CustomerApplication.class, args);
		
	}

}

//if you want to run application in 2 ports, then
//-> run as configuration-> arguments-> program args
// type as --server.port=9000

//sleuth and zipkin dependency should be added in eureka server as well
// add dependencies in eureka server,customer,fraud,notification