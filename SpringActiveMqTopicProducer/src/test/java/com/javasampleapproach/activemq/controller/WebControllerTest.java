package com.javasampleapproach.activemq.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.javasampleapproach.activemq.jms.JmsPublisher;

public class WebControllerTest {
	WebController controller;
	JmsPublisher mockPublisher;
	
	@Before
	public void before() {
		controller = new WebController();
		mockPublisher = mock(JmsPublisher.class);
		controller.jmsPublisher = mockPublisher;
	}
	
	@After
	public void after() {
		verify(mockPublisher);
	}
	
	@Test
	public void testPublish() {
		String testMsg = "msg";
		String response = controller.publish(testMsg);
		String expectedResponse = "MESSAGE PUBLISHED: "+testMsg;
		assertEquals(expectedResponse, response);
	}

}
