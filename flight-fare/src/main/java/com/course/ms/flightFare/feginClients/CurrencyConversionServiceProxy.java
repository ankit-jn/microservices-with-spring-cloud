package com.course.ms.flightFare.feginClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.ms.flightFare.models.CurrencyConversionVO;

//@FeignClient(name = "currency-conversion")
@FeignClient(name = "zuul-service-gateway")
@RequestMapping(value = "/flights/cc/api/v1")
public interface CurrencyConversionServiceProxy {

	@GetMapping(value = "/from/{from}/to/{to}")
	public CurrencyConversionVO convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to);

}
