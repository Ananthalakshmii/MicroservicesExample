package com.accolite.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_sequence",sequenceName = "customer_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_sequence")
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
}
