package org.rvslab.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component 
@Lazy
class Sender {
	
	RabbitMessagingTemplate template;
	private static final Logger logger = LoggerFactory.getLogger(Sender.class);
	
	@Autowired
	Sender(RabbitMessagingTemplate template){
		this.template = template;
	}

	@Bean
	Queue queue() {
		return new Queue("CustomerQ", false);
	}
	
	public void send(String message){
		logger.info("Send message to CustomerQ : " + message);
		template.convertAndSend("CustomerQ", message);
	}
}
