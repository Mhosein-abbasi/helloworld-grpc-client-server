package com.example.client;

import org.HelloWorldRequestsProtoGrpc;
import org.HelloWorldServiceGrpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        final HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);

        HelloWorldRequestsProtoGrpc.sayHelloResponse response = stub.say(HelloWorldRequestsProtoGrpc.sayHelloRequest.newBuilder()
                .setName("jon")
                .build());

        System.out.println(response);
    }

}
