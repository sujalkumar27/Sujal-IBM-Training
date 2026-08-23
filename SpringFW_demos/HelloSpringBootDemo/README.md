# HelloSpringBootDemo — Spring Boot fundamentals

A minimal Spring Boot web app. Read the code in this order:

1. `pom.xml` — how dependencies work (starters + parent)
2. `HelloSpringBootApplication.java` — the entry point and `@SpringBootApplication`
3. `service/GreetingService.java` — a Spring-managed bean
4. `controller/GreetingController.java` — REST endpoints + DI
5. `application.properties` — externalized configuration

## Concepts you'll pick up

| Concept | Where |
|---|---|
| Auto-configuration | `@SpringBootApplication` |
| Component scanning | package layout |
| IoC / DI | constructor injection in `GreetingController` |
| Bean scope | `@Service` singleton |
| REST endpoint | `@RestController`, `@GetMapping` |
| Query params | `@RequestParam` |
| JSON serialization | `InfoResponse` record |
| Property injection | `@Value` |
| App lifecycle hook | `CommandLineRunner` bean |
| Embedded server | included by `spring-boot-starter-web` |

## Run it

```powershell
cd HelloSpringBootDemo
mvn spring-boot:run
```

Then:
- http://localhost:8080/hello
- http://localhost:8080/hello?name=Sujal
- http://localhost:8080/info

## What Spring Boot did for you

- Started an embedded Tomcat on port 8080 — no `web.xml`, no external server.
- Scanned `com.example.hello.**` for beans and wired them.
- Read `application.properties` and injected `${app.greeting}`.
- Registered Jackson so returned Java objects come out as JSON.

All of that was zero configuration on your side — that is the "convention over configuration" idea.
