package com.s2u2m.iam.sample.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IamSampleOauth2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IamSampleOauth2Application.class, args);
    }
}
