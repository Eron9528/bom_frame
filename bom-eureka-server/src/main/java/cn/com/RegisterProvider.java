package cn.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer

public class RegisterProvider {
    public static void main(String[] args) {
        SpringApplication.run(RegisterProvider.class, args);
    }

}
