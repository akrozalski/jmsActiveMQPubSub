package com.javasampleapproach.activemq.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.javasampleapproach.activemq.models.Company;


@Component
public class JmsSubscriber {
	
	@JmsListener(destination = "${jsa.activemq.topic}")
	public void receive(String msg){
		System.out.println("Recieved Message: " + msg);
	}
}
