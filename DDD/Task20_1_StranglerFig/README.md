# Task 20.1 — Strangler Fig Pattern

An API Gateway (Spring Cloud Gateway) routes traffic between the new
microservice and the legacy monolith:

- `/orders/**`   -> new **Orders Microservice**  (`http://localhost:8081`)
- `/inventory/**` -> **Legacy Monolith**         (`http://localhost:9090`)

Over time, more paths get moved off the monolith until it is "strangled".

## Files
- `src/main/java/com/example/gateway/GatewayApplication.java`
- `src/main/resources/application.yml`

## How it would run
1. Start the legacy monolith on port 9090.
2. Start the new orders microservice on port 8081.
3. Start this gateway on port 8080.
4. Requests to `http://localhost:8080/orders/123` are forwarded to the new
   service; `http://localhost:8080/inventory/xyz` still goes to the monolith.
