package com.course.ms.currencyConversion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.ms.currencyConversion.dao.CurrencyConversionRepository;
import com.course.ms.currencyConversion.models.CurrencyConverter;

@RestController
@RequestMapping(value = "/api/v1")
public class ConvertCurrencyController {

	@Autowired
	private CurrencyConversionRepository repository;
	
	@GetMapping(value = "/from/{from}/to/{to}")
	public CurrencyConverter convertCurrency(@PathVariable String from, @PathVariable String to) {
		CurrencyConverter converter = new CurrencyConverter(null, from, to, null);
		Example<CurrencyConverter> conversionFilter = Example.of(converter);
		return repository.findOne(conversionFilter).get();
	}
}
