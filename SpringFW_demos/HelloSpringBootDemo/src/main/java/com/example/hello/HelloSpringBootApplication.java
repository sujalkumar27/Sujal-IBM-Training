package com.example.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @SpringBootApplication is a meta-annotation. It combines three things:
 *   1) @Configuration       -> this class can define @Bean methods
 *   2) @EnableAutoConfiguration -> Boot inspects the classpath and auto-wires
 *      sensible defaults (e.g. sees spring-web -> starts embedded Tomcat on 8080)
 *   3) @ComponentScan       -> scans this package and sub-packages for
 *      @Component / @Service / @RestController / @Repository beans
 *
 * Because of #3, keep your main class in the top-level package
 * (com.example.hello) so scanning reaches everything below it.
 */
@SpringBootApplication
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		// Bootstraps the ApplicationContext (the IoC container), starts
		// embedded Tomcat, and blocks until the app is shut down.
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}

	/**
	 * CommandLineRunner runs ONCE after the context is ready.
	 * Great place to see that the container really did construct your beans.
	 */
	@Bean
	CommandLineRunner startupLog() {
		return args -> System.out.println(">>> App is up. Try http://localhost:8080/hello");
	}
}
