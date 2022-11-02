package com.course.ms.flightFare.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.ms.flightFare.models.FlightFare;
import com.course.ms.flightFare.services.FlightFareService;

@RestController
@RequestMapping(value = "/api/v1/flight/{flightCode}/fare/{currency}")
public class FlightFareController {

	@Autowired
	private FlightFareService service;

	@Value("${base.currency:USD}")
	private String baseCurrency;

	@GetMapping
	public FlightFare getSingleTicketFare(@PathVariable String flightCode, @PathVariable String currency) {
		System.out.println(System.currentTimeMillis());
		FlightFare fare = service.getFlightFare(flightCode);
		fare.setCurrency(currency);
		if (!baseCurrency.equals(currency)) {
			BigDecimal conversionRate = service.getConversion(currency);
			BigDecimal convertedFare = fare.getFlightFare().multiply(conversionRate);
			fare.setFlightFare(convertedFare);
		}
		System.out.println(System.currentTimeMillis());
		return fare;
	}

}
