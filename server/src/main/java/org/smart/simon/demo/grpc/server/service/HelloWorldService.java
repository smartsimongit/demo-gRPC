package org.smart.simon.demo.grpc.server.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.smart.simon.demo.grpc.GreeterGrpc;
import org.smart.simon.demo.grpc.HelloWorldProto;

@GrpcService
public class HelloWorldService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloWorldProto.HelloRequest request, StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
        String responseMessage = "Hello, " + request.getName() + ". Your message is " + request.getText();
        HelloWorldProto.HelloReply reply =
                HelloWorldProto.HelloReply
                        .newBuilder()
                        .setMessage(responseMessage)
                        .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
