package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * You write an INTERFACE — Spring Data JPA generates the implementation at
 * runtime. No SQL, no boilerplate.
 *
 * JpaRepository<Book, Long> already gives you:
 *   findAll(), findById(id), save(entity), deleteById(id), count(), etc.
 *
 * You can also declare "derived query" methods — Spring parses the method
 * name and builds the query for you. Example below:
 *   findByAuthor -> SELECT * FROM book WHERE author = ?
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByAuthor(String author);
}
