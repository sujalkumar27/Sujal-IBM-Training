# Task 20.7 — Avoiding the Distributed Monolith (Sync REST → Kafka)

Two microservices that used to be coupled by a synchronous REST call are
decoupled by publishing / consuming a Kafka event.

## Before (distributed monolith)
```
   POST /orders                 HTTP (blocking)
   ┌─────────────┐   ─────────────►   ┌──────────────┐
   │  Service A  │                    │  Service B   │
   │  (Orders)   │   ◄─────────────   │ (Inventory)  │
   └─────────────┘   200 OK           └──────────────┘

   If B is slow / down, A is slow / fails too.
```

## After (event-driven)
```
   POST /orders                    Kafka topic
   ┌─────────────┐   publish──►   ┌──────────────┐   consume──►  ┌──────────────┐
   │  Service A  │                │  order-      │                │  Service B   │
   │  (Orders)   │                │  created     │                │ (Inventory)  │
   └─────────────┘                └──────────────┘                └──────────────┘

   A returns immediately; B processes when ready. Loose coupling.
```

## Folders
- `service-a-orders/`     — REST endpoint that publishes `OrderCreatedEvent`
- `service-b-inventory/`  — Kafka listener that reserves stock
- `docker-compose.yml`    — local Kafka broker for demo

## Kafka topic
`order.created`  (JSON payload)

## Try it
1. `docker compose up -d` (Kafka on localhost:9092)
2. Start Service A on 8081, Service B on 8082
3. `POST http://localhost:8081/orders  { "sku": "SKU1", "qty": 3 }`
4. Service A returns 202 instantly; Service B logs the reservation.
