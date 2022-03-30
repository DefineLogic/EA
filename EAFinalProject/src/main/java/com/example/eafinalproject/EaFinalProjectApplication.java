package com.example.eafinalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EaFinalProjectApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(EaFinalProjectApplication.class, args);
//    }

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(EaFinalProjectApplication.class, args);
    }

    public static void restart(String env) {

        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(EaFinalProjectApplication.class, "--spring.profiles.active=" + env);
        });

        thread.setDaemon(false);
        thread.start();
    }
}
