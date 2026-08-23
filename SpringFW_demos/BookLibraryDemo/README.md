# BookLibraryDemo — layered CRUD with Spring Boot + JPA

A realistic REST API showing the standard **Controller → Service → Repository → Entity** pattern.

## Read the code in this order

1. `pom.xml` — new starters: `data-jpa`, `validation`, and `h2`
2. `BookLibraryApplication.java` — same entry point idea as Example 1
3. `entity/Book.java` — how a Java class maps to a DB table
4. `repository/BookRepository.java` — Spring Data auto-implements the interface
5. `service/BookService.java` — business logic, uses the repository
6. `controller/BookController.java` — REST endpoints, uses the service
7. `exception/GlobalExceptionHandler.java` — centralized error → JSON translation
8. `application.properties` — DB config, H2 console, JPA settings
9. `data.sql` — seed rows at startup

## Layer diagram

```
HTTP request
    ↓
[BookController]   <-- @RestController, @RequestMapping, @Valid
    ↓
[BookService]      <-- @Service, business rules
    ↓
[BookRepository]   <-- extends JpaRepository (Spring generates SQL)
    ↓
[Book entity]      <-- @Entity, mapped to BOOK table in H2
    ↓
   H2 in-memory DB
```

## Run it

```powershell
cd BookLibraryDemo
mvn spring-boot:run
```

Then hit the API on port **8081**:

| Method | URL                                | What it does                |
|--------|------------------------------------|-----------------------------|
| GET    | `/api/books`                       | list all                    |
| GET    | `/api/books?author=Joshua%20Bloch` | filter by author            |
| GET    | `/api/books/1`                     | one book (404 if missing)   |
| POST   | `/api/books`                       | create (JSON body)          |
| PUT    | `/api/books/1`                     | update                      |
| DELETE | `/api/books/1`                     | delete (returns 204)        |

Sample POST body:

```json
{ "title": "Refactoring", "author": "Martin Fowler", "publishedYear": 2018 }
```

Send `{}` and watch the validation errors come back as clean JSON — that's the `GlobalExceptionHandler` at work.

## Explore the database

Open http://localhost:8081/h2-console, use JDBC URL `jdbc:h2:mem:testdb`, user `sa`, blank password. Run `SELECT * FROM BOOK;` and see the seed rows plus anything you inserted through the API.

## Concepts you'll pick up

| Concept                         | Where                                            |
|--------------------------------|--------------------------------------------------|
| Layered architecture           | package structure                                |
| ORM / JPA                      | `@Entity`, `@Id`, `@GeneratedValue`              |
| Spring Data repositories       | `extends JpaRepository<Book, Long>`              |
| Derived query methods          | `findByAuthor(...)`                              |
| Auto-configured DataSource     | properties + H2 on classpath                     |
| CRUD REST semantics            | `@GetMapping` / `@PostMapping` / `@PutMapping` / `@DeleteMapping` |
| Path & query params            | `@PathVariable`, `@RequestParam`                 |
| Request body binding           | `@RequestBody`                                   |
| Bean Validation                | `@Valid`, `@NotBlank`, `@Min`                    |
| Centralized error handling     | `@RestControllerAdvice`, `@ExceptionHandler`     |
| HTTP status codes              | `ResponseEntity.created(...)`, `@ResponseStatus` |
| DB seeding                     | `data.sql`                                       |
