package com.javasampleapproach.activemq.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class JmsSubscriber {
	
	@JmsListener(destination = "${jsa.activemq.topic}", selector = "length < 5", id = "client",
			subscription = "brokerClientId",
			containerFactory = "jsaFactory" )
	public void receive(String msg){
		System.out.println("Recieved Message: " + msg);
	}
}
