package com.course.ms.flightFare;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.course.ms.flightFare.dao.FlightFareRepository;
import com.course.ms.flightFare.models.FlightFare;

@Component
public class BootstrapRepository implements CommandLineRunner {

	private FlightFareRepository flightFareRepository;

	public BootstrapRepository(FlightFareRepository flightFareRepository) {
		super();
		this.flightFareRepository = flightFareRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		FlightFare fare1 = new FlightFare(1L, "UL-191", BigDecimal.valueOf(1000));
		FlightFare fare2 = new FlightFare(2L, "UL-192", BigDecimal.valueOf(2000));
		FlightFare fare3 = new FlightFare(3L, "UL-193", BigDecimal.valueOf(3000));
		FlightFare fare4 = new FlightFare(4L, "UL-194", BigDecimal.valueOf(4000));
		
		flightFareRepository.save(fare1);
		flightFareRepository.save(fare2);
		flightFareRepository.save(fare3);
		flightFareRepository.save(fare4);
	}

}
