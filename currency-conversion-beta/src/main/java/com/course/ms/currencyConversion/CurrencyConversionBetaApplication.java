package com.course.ms.currencyConversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyConversionBetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionBetaApplication.class, args);
	}

}

