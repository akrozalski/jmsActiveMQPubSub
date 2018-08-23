package com.javasampleapproach.activemq.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
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
    
	@Bean
	public JmsListenerContainerFactory<?> jsaFactory(ConnectionFactory connectionFactory,
	                                                DefaultJmsListenerContainerFactoryConfigurer configurer) {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory());
	    factory.setClientId("brokerClientId2");
	    factory.setPubSubDomain(true);
	    factory.setSubscriptionDurable(true);
	    configurer.configure(factory, connectionFactory);
	    return factory;
	}
}
