package com.javasampleapproach.activemq.config;

import static org.junit.Assert.*;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;

public class ConnectionFactoryConfigTest {

	private String brokerUrl, username, password;
	private ConnectionFactoryConfig cfConfig;
	
	@Before 
	public void before() {
		brokerUrl = "tcp://localhost:61616";
		username = "admin";
		password = "admin";
		cfConfig = new ConnectionFactoryConfig();
		cfConfig.brokerUrl = brokerUrl;
		cfConfig.userName = username;
		cfConfig.password = password;
	}

	@Test
	public void testConnectionFactoryBrokerUrl() {
		ActiveMQConnectionFactory factory = (ActiveMQConnectionFactory) cfConfig.connectionFactory();
		assertEquals(brokerUrl, factory.getBrokerURL());
	}
	@Test
	public void testConnectionFactoryUsername() {
		ActiveMQConnectionFactory factory = (ActiveMQConnectionFactory) cfConfig.connectionFactory();
		assertEquals(username, factory.getUserName());
	}
	
	@Test
	public void testConnectionFactoryPassword() {
		ActiveMQConnectionFactory factory = (ActiveMQConnectionFactory) cfConfig.connectionFactory();
		assertEquals(username, factory.getPassword());
	}



}
