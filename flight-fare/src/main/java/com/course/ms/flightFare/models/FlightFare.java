package com.course.ms.flightFare.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlightFare {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String flightCode;
	private BigDecimal flightFare;
	private String currency;

	public FlightFare() {
		super();
	}

	public FlightFare(Long id, String flightCode, BigDecimal flightFare) {
		super();
		this.id = id;
		this.flightCode = flightCode;
		this.flightFare = flightFare;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public BigDecimal getFlightFare() {
		return flightFare;
	}

	public void setFlightFare(BigDecimal flightFare) {
		this.flightFare = flightFare;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
