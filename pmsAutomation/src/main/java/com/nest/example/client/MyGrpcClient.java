package com.nest.example.client;

import com.example.server.GreetingServiceGrpc;
import com.example.server.HelloRequest;
import com.example.server.HelloResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {
	
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9080).usePlaintext(true).build();

		GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
		HelloResponse response = stub.greeting(HelloRequest.newBuilder()
										.setName("Luis")
										.putBagOfTricks("truco1", "dormir")
										.addHobbies("foto").build());

		System.out.println(response.toString());
	}

	/**
	 * 
	 * @param Name
	 * @param mBag
	 * @param hobbies
	 * @return
	 */
	public String getGrpcGreetingMessage(String name, String trickTitle, String trickName, String hobbies) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9080).usePlaintext(true).build();

		GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
		HelloResponse response = stub.greeting(HelloRequest.newBuilder()
										.setName(name)
										.putBagOfTricks(trickTitle, trickName)
										.addHobbies(hobbies).build());

		return response.getGreeting();
	}
}
