package com.accolite.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepo extends JpaRepository<Fraud, Integer>{

}
