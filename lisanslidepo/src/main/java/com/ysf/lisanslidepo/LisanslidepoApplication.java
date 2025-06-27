package com.ysf.lisanslidepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LisanslidepoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LisanslidepoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LisanslidepoApplication.class);
    }
}
