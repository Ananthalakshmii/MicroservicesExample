package com.accolite.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		value="fraud"
		//path="/api/v1/fraud-check/{customerId}"
		)
public interface FraudClient {
	@GetMapping("/api/v1/fraud-check/{customerId}")
	FraudResponse isFraudster(@PathVariable Integer customerId);

}
