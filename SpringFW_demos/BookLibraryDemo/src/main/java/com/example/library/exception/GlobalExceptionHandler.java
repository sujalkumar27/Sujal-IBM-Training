package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @RestControllerAdvice = cross-cutting exception handler for ALL controllers.
 * Any exception a controller throws that matches an @ExceptionHandler method
 * below is converted into a clean JSON error response.
 *
 * This is how you avoid try/catch clutter inside each controller method.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	// 404 for our custom "not found" exception
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleNotFound(BookNotFoundException ex) {
		return build(HttpStatus.NOT_FOUND, ex.getMessage());
	}

	// 400 with field-level messages when @Valid fails
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
		Map<String, Object> body = baseBody(HttpStatus.BAD_REQUEST, "Validation failed");
		Map<String, String> fieldErrors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(fe -> fieldErrors.put(fe.getField(), fe.getDefaultMessage()));
		body.put("errors", fieldErrors);
		return ResponseEntity.badRequest().body(body);
	}

	private ResponseEntity<Map<String, Object>> build(HttpStatus status, String message) {
		return ResponseEntity.status(status).body(baseBody(status, message));
	}

	private Map<String, Object> baseBody(HttpStatus status, String message) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", Instant.now().toString());
		body.put("status", status.value());
		body.put("error", status.getReasonPhrase());
		body.put("message", message);
		return body;
	}
}
