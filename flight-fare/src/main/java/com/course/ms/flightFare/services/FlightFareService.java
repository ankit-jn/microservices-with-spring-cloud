package com.course.ms.flightFare.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.course.ms.flightFare.dao.FlightFareRepository;
import com.course.ms.flightFare.feginClients.CurrencyConversionServiceProxy;
import com.course.ms.flightFare.models.CurrencyConversionVO;
import com.course.ms.flightFare.models.FlightFare;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class FlightFareService {

	@Autowired
	private FlightFareRepository flightFareRepository;

	@Value("${use.eureka.client:false}")
	private boolean useEurekaClient;

	@Value("${use.ribbon.backed.rest.template:false}")
	private boolean useRibbonBackedRestTemplate;

	@Value("${use.feign.client:false}")
	private boolean useFeignClient;

	@Autowired
	private CurrencyConversionServiceProxy feignProxy;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	@Value("${base.currency:USD}")
	private String baseCurrency;

	public BigDecimal getConversion(String toCurrency) {
		if (useEurekaClient) {
			Application app = eurekaClient.getApplication("currency-conversion");
			List<InstanceInfo> instances = app.getInstances();

			String serviceUri = String.format("%sapi/v1/from/{from}/to/{to}", instances.get(0).getHomePageUrl()); // http://localhost:7101/

			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> urlPathVariables = new HashMap<>();
			urlPathVariables.put("from", baseCurrency);
			urlPathVariables.put("to", toCurrency);

			ResponseEntity<CurrencyConversionVO> responseEntity = restTemplate.getForEntity(serviceUri,
					CurrencyConversionVO.class, urlPathVariables);
			CurrencyConversionVO converter = responseEntity.getBody();
			return converter.getConversionRate();
		} else if (useRibbonBackedRestTemplate) {
			Map<String, String> urlPathVariables = new HashMap<>();
			urlPathVariables.put("from", baseCurrency);
			urlPathVariables.put("to", toCurrency);
			ResponseEntity<CurrencyConversionVO> responseEntity = restTemplate.getForEntity(
					"http://currency-conversion/api/v1/from/{from}/to/{to}", CurrencyConversionVO.class,
					urlPathVariables);
			CurrencyConversionVO converter = responseEntity.getBody();
			return converter.getConversionRate();
		} else if (useFeignClient) {
			System.out.println("using feign...........");
			CurrencyConversionVO converter = feignProxy.convertCurrency(baseCurrency, toCurrency);
			return converter.getConversionRate();
		} else {
			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> urlPathVariables = new HashMap<>();
			urlPathVariables.put("from", baseCurrency);
			urlPathVariables.put("to", toCurrency);
			ResponseEntity<CurrencyConversionVO> responseEntity = restTemplate.getForEntity(
					"http://localhost:7101/api/v1/from/{from}/to/{to}", CurrencyConversionVO.class, urlPathVariables);
			CurrencyConversionVO converter = responseEntity.getBody();
			return converter.getConversionRate();
		}
	}
	
	@HystrixCommand(commandProperties= {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="7000")
	})
	public FlightFare getFlightFare(String flightCode) {
		FlightFare flight = new FlightFare(null, flightCode, null);
		Example<FlightFare> fareFilter = Example.of(flight);
		//sleepRandomly();
		FlightFare fare = flightFareRepository.findOne(fareFilter).get();
		return fare;
	}

	public void sleepRandomly() {
		Random rand = new Random();
		int randomNum = rand.nextInt(3) + 1;
		if(randomNum == 3) {
			System.out.println("It is a chance for demonstrating Hystrix action");
			try {
				System.out.println("Start sleeping...." + System.currentTimeMillis());
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Hystrix thread interupted...." + System.currentTimeMillis());
				e.printStackTrace();
			}
		}
	}
	
}
