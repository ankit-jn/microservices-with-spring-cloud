package com.course.ms.flightSchedule.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.ms.flightSchedule.models.Flight;
import com.course.ms.flightSchedule.services.FlightScheduleService;

@RestController
@RequestMapping(value = "/api/v1/flights")
public class FlightScheduleController {

	@Resource(name = "flightScheduleService")
	private FlightScheduleService flightScheduleService;

	@GetMapping(value = "/from/{from}/to/{to}")
	public List<Flight> getFlights(@PathVariable String from, @PathVariable String to) {
		List<Flight> flightList = flightScheduleService.getFlights(from, to);
		return flightList;
	}

}
