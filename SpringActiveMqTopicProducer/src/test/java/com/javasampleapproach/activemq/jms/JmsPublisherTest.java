package com.javasampleapproach.activemq.jms;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;

public class JmsPublisherTest {
	
	private JmsTemplate mockTemplate;
	private String topic;
	
	private JmsPublisher publisher;
	
	@Before
	public void before() {
		mockTemplate = mock(JmsTemplate.class);
		topic = "test-topic";
		publisher = new JmsPublisher();
		publisher.jmsTemplate = mockTemplate;
		publisher.topic = topic;
	}
	
	@Test
	public void testSend() {
		String testMsg = "msg";
		String expectedResponse = "Message published: " + testMsg;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		publisher.send(testMsg);
		assertEquals(expectedResponse+System.getProperty("line.separator"), os.toString());
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}

}
