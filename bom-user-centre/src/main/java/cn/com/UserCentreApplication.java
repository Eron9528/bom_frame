package cn.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserCentreApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCentreApplication.class,args);
    }
}
