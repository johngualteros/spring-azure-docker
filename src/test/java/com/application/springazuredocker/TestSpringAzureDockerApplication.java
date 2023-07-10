package com.application.springazuredocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringAzureDockerApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringAzureDockerApplication::main).with(TestSpringAzureDockerApplication.class).run(args);
    }

}
