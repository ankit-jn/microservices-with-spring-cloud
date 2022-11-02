package com.course.ms.currencyConversion;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.course.ms.currencyConversion.dao.CurrencyConversionRepository;
import com.course.ms.currencyConversion.models.CurrencyConverter;

@Component
public class BootstrapRepository implements CommandLineRunner {

	private CurrencyConversionRepository repository;

	public BootstrapRepository(CurrencyConversionRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		CurrencyConverter converter1 = new CurrencyConverter(1L, "USD", "INR", BigDecimal.valueOf(74.10));
		CurrencyConverter converter2 = new CurrencyConverter(2L, "USD", "JPY", BigDecimal.valueOf(111.12));

		repository.save(converter1);
		repository.save(converter2);
	}

}
