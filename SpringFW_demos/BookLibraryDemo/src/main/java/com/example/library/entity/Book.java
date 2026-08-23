package com.example.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * @Entity says: "this class maps to a database table".
 * Table name defaults to the class name ("BOOK").
 *
 * The validation annotations (@NotBlank, @Min) are checked when a controller
 * method marks the request body with @Valid — they are NOT DB constraints.
 */
@Entity
public class Book {

	@Id                                             // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // DB auto-increment
	private Long id;

	@NotBlank(message = "title is required")
	private String title;

	@NotBlank(message = "author is required")
	private String author;

	@Min(value = 0, message = "year must be >= 0")
	private int publishedYear;

	// JPA requires a no-args constructor
	public Book() {}

	public Book(String title, String author, int publishedYear) {
		this.title = title;
		this.author = author;
		this.publishedYear = publishedYear;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	public int getPublishedYear() { return publishedYear; }
	public void setPublishedYear(int publishedYear) { this.publishedYear = publishedYear; }
}
