package org.cvt.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.cvt.grpc.HelloRequest;
import org.cvt.grpc.HelloResponse;
import org.cvt.grpc.HelloServiceGrpc;

import java.util.Scanner;

public class GrpcClient {
  public static void main(String[] args) {
    ManagedChannel channel =
        ManagedChannelBuilder.forAddress("localhost", 5555).usePlaintext().build();
    HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Please enter a name:");
      final String enteredText = scanner.nextLine();
      if (enteredText.equalsIgnoreCase("EXIT")) {
        break;
      }
      HelloResponse helloResponse =
          stub.sayHello(HelloRequest.newBuilder().setName(enteredText).build());
      System.out.println(helloResponse.getMessage());
    }
    channel.shutdown();
  }
}
