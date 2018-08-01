package com.ponxu.test.controller;

import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.GreeterOuterClass;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author xuwenzhao
 * @date 2018-08-01
 */
@GRpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {
    @Value("${grpc.port}")
    private int port;

    @Override
    public void sayHello(GreeterOuterClass.HelloRequest request, StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
        String message = "Hello, " + request.getName() + " " + port;
        final GreeterOuterClass.HelloReply.Builder replyBuilder = GreeterOuterClass.HelloReply.newBuilder().setMessage(message);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
        // log.info("Returning " + message);
    }
}
