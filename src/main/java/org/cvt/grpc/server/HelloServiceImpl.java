package org.cvt.grpc.server;

import io.grpc.stub.StreamObserver;
import org.cvt.grpc.HelloRequest;
import org.cvt.grpc.HelloResponse;
import org.cvt.grpc.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

    String greeting = new StringBuilder().append("Hello, ").append(request.getName()).toString();
    HelloResponse response = HelloResponse.newBuilder().setMessage(greeting).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
