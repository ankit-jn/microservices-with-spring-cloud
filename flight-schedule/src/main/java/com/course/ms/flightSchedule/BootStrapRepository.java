package com.course.ms.flightSchedule;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.course.ms.flightSchedule.dao.FlightScheduleRepository;
import com.course.ms.flightSchedule.models.Flight;

@Component
public class BootStrapRepository implements CommandLineRunner {

	private final FlightScheduleRepository flightRepository;

	public BootStrapRepository(FlightScheduleRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Flight flight1 = new Flight(1L, "UL-191", "DEL", "TYO", "Srilankan Airlines", "05:10", "07:35");
		Flight flight2 = new Flight(2L, "UL-192", "DEL", "TYO", "China Southern Airlines", "05:15", "09:35");
		Flight flight3 = new Flight(3L, "UL-193", "DEL", "TYO", "China Southern Airlines", "12:30", "14:35");
		Flight flight4 = new Flight(4L, "UL-194", "DEL", "TYO", "Srilankan Airlines", "15:10", "18:40");

		flightRepository.save(flight1);
		flightRepository.save(flight2);
		flightRepository.save(flight3);
		flightRepository.save(flight4);

	}

}
