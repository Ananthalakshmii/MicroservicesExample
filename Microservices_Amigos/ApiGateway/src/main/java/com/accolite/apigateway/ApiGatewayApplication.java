package com.accolite.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}

// will work with http://localhost:8085/api/v1/customers -> apigateway forwards the request to customer-- load balanced
//can trace it in zipkin as well.. api gateway->customer->fraud->notification