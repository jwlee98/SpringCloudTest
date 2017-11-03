package org.rvslab.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(CustomerRespository customerRepository) {
		logger.info("started ");
		return (evt) ->  {
							customerRepository.save(new Customer("Adam","adam@boot.com"));
							customerRepository.save(new Customer("John","john@boot.com"));
							customerRepository.save(new Customer("Smith","smith@boot.com"));
							customerRepository.save(new Customer("Edgar","edgar@boot.com"));
							customerRepository.save(new Customer("Martin","martin@boot.com"));
							customerRepository.save(new Customer("Tom","tom@boot.com"));
							customerRepository.save(new Customer("Sean","sean@boot.com"));
						};
	}
}
