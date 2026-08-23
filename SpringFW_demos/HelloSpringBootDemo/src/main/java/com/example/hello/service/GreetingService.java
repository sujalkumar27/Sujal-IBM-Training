package com.example.hello.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Service marks this class as a Spring-managed bean.
 * At startup Spring creates ONE instance (singleton) and stores it in the
 * ApplicationContext. Anywhere that asks for a GreetingService will get
 * this same instance — that's Inversion of Control (IoC).
 */
@Service
public class GreetingService {

	// @Value pulls a property from application.properties (or env vars).
	// The ':Hello' part is the default if the property is missing.
	@Value("${app.greeting:Hello}")
	private String greeting;

	public String greet(String name) {
		return greeting + ", " + name + "!";
	}
}
