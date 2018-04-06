package com.nest.example.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MyGrpcServer {
	private Server server;

	public static void main(String[] args) {
		Server server = ServerBuilder.forPort(9080).addService(new GreetingServiceImpl()).build();
		try {
			server.start();
//			server.awaitTermination();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Server started at port 9080");
	}
	
	public void start() {
		server = ServerBuilder.forPort(9080).addService(new GreetingServiceImpl()).build();
		try {
			server.start();
//			server.awaitTermination();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Server started at port 9080");
		return;
	}
	
	public void shutdown() {
		server.shutdown();
		System.out.println("Server has stoped");
	}

}
