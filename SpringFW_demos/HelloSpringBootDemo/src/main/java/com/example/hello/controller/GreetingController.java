package com.example.hello.controller;

import com.example.hello.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController = @Controller + @ResponseBody.
 * Every returned object is serialized to JSON by Jackson automatically.
 */
@RestController
public class GreetingController {

	private final GreetingService greetingService;

	/**
	 * Constructor injection (preferred over field @Autowired):
	 *  - final field -> immutable, easier to test
	 *  - Spring 4.3+ auto-wires the single constructor with no annotation needed
	 */
	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	// GET http://localhost:8080/hello?name=Sujal
	@GetMapping("/hello")
	public String hello(@RequestParam(defaultValue = "World") String name) {
		return greetingService.greet(name);
	}

	// GET http://localhost:8080/info -> returns JSON, not a plain string
	@GetMapping("/info")
	public InfoResponse info() {
		return new InfoResponse("HelloSpringBootDemo", "1.0.0");
	}

	// A plain Java record; Jackson turns it into {"name":"...","version":"..."}
	public record InfoResponse(String name, String version) {}
}
