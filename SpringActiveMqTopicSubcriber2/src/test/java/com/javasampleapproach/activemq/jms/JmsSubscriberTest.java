package com.javasampleapproach.activemq.jms;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class JmsSubscriberTest {
	
	JmsSubscriber subscriber;

	@Before
	public void before() {
		subscriber = new JmsSubscriber();
	}
	
	@Test
	public void testReceive() {
		String testMsg = "msg";
		String expectedResponse = "Recieved Message: " + testMsg;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		subscriber.receive(testMsg);
		assertEquals(expectedResponse+System.getProperty("line.separator"), os.toString());
		PrintStream originalOut = System.out;
		System.setOut(originalOut);

	}

}
