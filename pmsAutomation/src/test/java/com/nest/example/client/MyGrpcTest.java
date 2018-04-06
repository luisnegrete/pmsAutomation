package com.nest.example.client;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nest.example.client.MyGrpcClient;
import com.nest.example.service.MyGrpcServer;

public class MyGrpcTest {
	MyGrpcServer server;
	
	@BeforeSuite
	public void setUp() {
		server = new MyGrpcServer();
		server.start();
	}
	
	@AfterSuite
	public void shutdown() {
		server.shutdown();
	}

	@DataProvider(name = "greetingProvider")
	public Object[][] createData1() {
		return new Object[][] { 
			{"Luis", "Truco 1", "Dormir :D", "Foto"},
		};
	}

	@Test(dataProvider="greetingProvider")
	public void testGreetingMessage(String name, String trickTitle, String trickName, String hobbies) {
		MyGrpcClient client = new MyGrpcClient();

		Assert.assertEquals(client.getGrpcGreetingMessage(name, trickTitle, trickName, hobbies), "Hola " + name +" que disfrutas " + hobbies);
	}
}
