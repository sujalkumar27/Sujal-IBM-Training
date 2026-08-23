package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * REST controller for the /api/books resource.
 *
 * @RequestMapping at the class level sets a common URL prefix. Individual
 * methods add path segments and HTTP verbs via @GetMapping / @PostMapping / etc.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// GET /api/books                -> all books
	// GET /api/books?author=Rowling -> filter by author (uses derived query)
	@GetMapping
	public List<Book> list(@RequestParam(required = false) String author) {
		return author == null ? bookService.findAll() : bookService.findByAuthor(author);
	}

	// GET /api/books/{id}
	@GetMapping("/{id}")
	public Book get(@PathVariable Long id) {
		return bookService.findById(id);
	}

	// POST /api/books  with JSON body -> 201 Created + Location header
	@PostMapping
	public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
		Book saved = bookService.create(book);
		URI location = URI.create("/api/books/" + saved.getId());
		return ResponseEntity.created(location).body(saved);
	}

	// PUT /api/books/{id}
	@PutMapping("/{id}")
	public Book update(@PathVariable Long id, @Valid @RequestBody Book book) {
		return bookService.update(id, book);
	}

	// DELETE /api/books/{id} -> 204 No Content
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		bookService.delete(id);
	}
}
