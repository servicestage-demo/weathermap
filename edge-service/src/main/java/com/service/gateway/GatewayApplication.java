package com.service.gateway;

import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableServiceComb
public class GatewayApplication {
    public static void main(String[] args) {
        try {
            new SpringApplicationBuilder().web(WebApplicationType.NONE).sources(GatewayApplication.class).run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
