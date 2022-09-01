package com.accolite.fraud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.clients.fraud.FraudClient;
import com.accolite.clients.fraud.FraudResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/fraud-check")
@Slf4j
public class FraudController {
	@Autowired
	private FraudService fraudService;
	
	@GetMapping("/{customerId}")
	public FraudResponse isFraudster(@PathVariable Integer customerId) {
		boolean isfraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
		log.info("fraud check request for customer {}",customerId);
		return new FraudResponse(isfraudulentCustomer);
		
	}

}
