package com.ponxu.test.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.ponxu.test.Greeting;
import com.ponxu.test.GreetingService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.GreeterOuterClass.HelloReply;
import io.grpc.examples.GreeterOuterClass.HelloRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ponxu
 * @date 2018-08-01
 */
@Component
public class GreetingServiceGRpc implements GreetingService {
    @Autowired
    private EurekaClient client;

    public Greeting hello(String name) {
        final InstanceInfo instanceInfo = client.getNextServerFromEureka("grpc-server", false);
        System.out.println(instanceInfo.getAppName());
        System.out.println(instanceInfo.getIPAddr());
        System.out.println(instanceInfo.getPort());

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort())
                .usePlaintext()
                .build();
        final GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        HelloRequest rq = HelloRequest.newBuilder().build();
        HelloReply rs = stub.sayHello(rq);
        return new Greeting(-1, rs.getMessage());
    }
}
