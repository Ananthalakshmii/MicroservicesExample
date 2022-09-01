package com.accolite.fraud;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudService {
	@Autowired
	private FraudRepo fraudRepo;

	public boolean isFraudulentCustomer(Integer customerId) {
		//own logic
		Fraud fraud= Fraud.builder()
				.customerId(customerId)
				.isFraudster(false)
				.createdAt(LocalDateTime.now())
				.build();
		
		fraudRepo.save(fraud);
		return false;
	}
}
