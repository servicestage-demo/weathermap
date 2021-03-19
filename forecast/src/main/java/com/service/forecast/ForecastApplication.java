package com.service.forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config/httpproxy.properties")
public class ForecastApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForecastApplication.class);
    }
}
