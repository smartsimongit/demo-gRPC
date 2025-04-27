package org.smart.simon.demo.grpc.client;

import org.smart.simon.demo.grpc.client.service.GrpcClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ClientApplication.class, args);
        GrpcClientService service = context.getBean(GrpcClientService.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String name = scanner.nextLine();
            String text = scanner.nextLine();
            String message = service.sayHello(name, text);
            System.out.println(message);
        }
    }

}
