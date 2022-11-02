package com.course.ms.flightSchedule.services;

import java.util.List;

import com.course.ms.flightSchedule.models.Flight;

public interface FlightScheduleService {

	List<Flight> getFlights(String from, String to);
}
