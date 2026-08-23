package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point.
 *
 * Because spring-boot-starter-data-jpa + H2 are on the classpath, Boot will:
 *   - configure a DataSource pointing at an in-memory H2
 *   - configure Hibernate as the JPA provider
 *   - scan for @Entity classes and create the schema
 *   - scan for interfaces extending JpaRepository and generate implementations
 *
 * All of that is triggered by @EnableAutoConfiguration inside @SpringBootApplication.
 */
@SpringBootApplication
public class BookLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookLibraryApplication.class, args);
	}
}
