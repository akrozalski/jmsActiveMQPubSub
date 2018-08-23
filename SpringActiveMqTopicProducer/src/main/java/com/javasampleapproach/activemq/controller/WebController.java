package com.javasampleapproach.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.activemq.jms.JmsPublisher;

@RestController
public class WebController {

	@Autowired
	JmsPublisher jmsPublisher;

	@RequestMapping(value="/publish")
	public String publish(@RequestParam("msg")String msg){
		jmsPublisher.send(msg);
		return "Message: "+msg +"\nSENT";
	}
	
}
