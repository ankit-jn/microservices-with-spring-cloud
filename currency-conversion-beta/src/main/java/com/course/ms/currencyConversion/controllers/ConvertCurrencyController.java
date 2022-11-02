package com.course.ms.currencyConversion.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.ms.currencyConversion.models.CurrencyConverter;

@RestController
@RequestMapping(value = "/api/v1")
public class ConvertCurrencyController {

	@GetMapping(value = "/from/{from}/to/{to}")
	public CurrencyConverter convertCurrency(@PathVariable String from, @PathVariable String to) {
		CurrencyConverter converter = new CurrencyConverter(1L, from, to, BigDecimal.valueOf(2L));
		return converter;
	}
}
