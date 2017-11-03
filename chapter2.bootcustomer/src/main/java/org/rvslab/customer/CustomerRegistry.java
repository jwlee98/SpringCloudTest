package org.rvslab.customer;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component 
@Lazy
class CustomerRegistry {
	
	CustomerRespository customerRespository;
	Sender sender;
	private static final Logger logger = LoggerFactory.getLogger(CustomerRegistry.class);
	
	@Autowired
	CustomerRegistry(CustomerRespository customerRespository, Sender sender){
		this.customerRespository = customerRespository;
		this.sender = sender;
	}
	
	Customer register(Customer customer){
		Optional<Customer> existingCustomer = customerRespository.findByName(customer.getName());
		if (existingCustomer.isPresent()){
			throw new RuntimeException("is already exists");
		} else {
			customerRespository.save(customer); 
			logger.info("AAA");
			sender.send(customer.getEmail());
		} 
		return customer;
	}
}
