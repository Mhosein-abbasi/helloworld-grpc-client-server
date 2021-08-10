package com.example.server;

import org.HelloWorldRequestsProtoGrpc;
import org.HelloWorldServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;

import io.grpc.stub.StreamObserver;

@GRpcService
public class Controller extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void say(HelloWorldRequestsProtoGrpc.sayHelloRequest request, StreamObserver<HelloWorldRequestsProtoGrpc.sayHelloResponse> responseObserver) {
        String name = request.getName();

        HelloWorldRequestsProtoGrpc.sayHelloResponse response = HelloWorldRequestsProtoGrpc.sayHelloResponse.newBuilder()
                .setSayHello("Hello " + name)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
