package com.javasampleapproach.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.activemq.jms.JmsPublisher;

@SpringBootApplication
public class SpringActiveMqTopicProducerApplication {

	@Autowired
	JmsPublisher publisher;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringActiveMqTopicProducerApplication.class, args);
	}
	
}
