package com.javasampleapproach.activemq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsPublisher {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${jsa.activemq.topic}")
	String topic;
	
	public void send(String msg){
		jmsTemplate.convertAndSend(topic, msg, m -> {
            m.setIntProperty("length", msg.length());
            return m;
        });
		System.out.println("Message published: "+msg);
	}
}
