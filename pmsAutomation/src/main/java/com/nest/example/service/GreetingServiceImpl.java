package com.nest.example.service;

import com.example.server.GreetingServiceGrpc;
import com.example.server.HelloRequest;
import com.example.server.HelloResponse;
import com.google.protobuf.ProtocolStringList;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

	@Override
	public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
		// Obteniendo los datos de Request
		String name = request.getName();
		String hobbie = "";
		ProtocolStringList lst = request.getHobbiesList();

		for (String string : lst) {
			hobbie += string;
		}

		// Armando el response
		HelloResponse response = HelloResponse.newBuilder()
												.setGreeting("Hola " + name + " que disfrutas " + hobbie)
												.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
