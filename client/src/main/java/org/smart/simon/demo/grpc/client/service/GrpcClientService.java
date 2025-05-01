package org.smart.simon.demo.grpc.client.service;


import net.devh.boot.grpc.client.inject.GrpcClient;
import org.smart.simon.demo.grpc.GreeterGrpc;
import org.smart.simon.demo.grpc.HelloWorldProto;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("myGrpcService")
    private GreeterGrpc.GreeterBlockingStub blockingStub;

    public String sayHello(String name, String text) {
        HelloWorldProto.HelloRequest request
                = HelloWorldProto
                .HelloRequest
                .newBuilder()
                .setName(name)
                .setText(text)
                .build();
        HelloWorldProto.HelloReply reply = blockingStub.sayHello(request);
        return reply.getMessage();
    }
}
