package com.external.service.greet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/name")
public class GreetServiceController {

	@GetMapping(value="/{name}")
	public String greetMe(@PathVariable("name") String name) {
		return String.format("Hello %s! How are you?", name); 
	}
}
