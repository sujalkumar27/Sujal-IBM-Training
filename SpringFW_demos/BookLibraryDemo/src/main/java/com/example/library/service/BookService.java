package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Service layer holds business logic. It sits BETWEEN controller and
 * repository so that:
 *   - controllers stay thin (HTTP concerns only)
 *   - business rules are unit-testable without HTTP
 *   - transactions and validation live in one place
 */
@Service
public class BookService {

	private final BookRepository bookRepository;

	// Constructor injection: Spring auto-supplies BookRepository at startup.
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException(id));
	}

	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	public Book create(Book book) {
		book.setId(null);           // ignore any id the client sent
		return bookRepository.save(book);
	}

	public Book update(Long id, Book updated) {
		Book existing = findById(id);
		existing.setTitle(updated.getTitle());
		existing.setAuthor(updated.getAuthor());
		existing.setPublishedYear(updated.getPublishedYear());
		return bookRepository.save(existing);
	}

	public void delete(Long id) {
		if (!bookRepository.existsById(id)) {
			throw new BookNotFoundException(id);
		}
		bookRepository.deleteById(id);
	}
}
