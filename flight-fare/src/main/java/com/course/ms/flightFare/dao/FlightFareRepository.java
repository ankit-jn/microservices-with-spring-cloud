package com.course.ms.flightFare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.ms.flightFare.models.FlightFare;

public interface FlightFareRepository extends JpaRepository<FlightFare, Long> {

}
