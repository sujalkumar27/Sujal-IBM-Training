package com.example.library.exception;

/**
 * A custom runtime exception. The GlobalExceptionHandler will translate
 * this into a clean 404 response instead of a 500 stack trace.
 */
public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(Long id) {
		super("Book not found with id " + id);
	}
}
