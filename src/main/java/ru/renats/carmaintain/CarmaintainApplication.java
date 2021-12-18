package ru.renats.carmaintain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CarmaintainApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarmaintainApplication.class, args);
    }

}
