package com.course.ms.serviceGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
//@EnableZuulServer
public class ZuulServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceGatewayApplication.class, args);
	}

}

