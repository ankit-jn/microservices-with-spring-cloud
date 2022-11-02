package com.course.ms.flightFare.models;

import java.math.BigDecimal;

public class CurrencyConversionVO {

	private String currencyFrom;
	private String currencyTo;
	private BigDecimal conversionRate;

	public CurrencyConversionVO() {
		super();
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

}
