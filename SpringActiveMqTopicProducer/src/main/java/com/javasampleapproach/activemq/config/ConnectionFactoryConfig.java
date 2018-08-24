package com.javasampleapproach.activemq.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class ConnectionFactoryConfig {
	@Value("${jsa.activemq.broker.url}")
	String brokerUrl;
	
	@Value("${jsa.activemq.broker.username}")
	String userName;
	
	@Value("${jsa.activemq.broker.password}")
	String password;

	/*
	 * Initial ConnectionFactory
	 */
    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUserName(userName);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }
    
    /*
     * Used for sending Messages.
     */
	@Bean
	public JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory());
	    template.setPubSubDomain(true);
	    return template;
	}
}
