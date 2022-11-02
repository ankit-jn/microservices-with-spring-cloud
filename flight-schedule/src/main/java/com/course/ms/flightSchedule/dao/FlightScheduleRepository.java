package com.course.ms.flightSchedule.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.ms.flightSchedule.models.Flight;

public interface FlightScheduleRepository extends JpaRepository<Flight, Long> {

}
