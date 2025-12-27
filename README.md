# EventFlow Commerce

Event-driven microservices demo (Java Spring Boot) with Order, Inventory, and Payment services.

## Services
- Order Service (creates orders, manages order lifecycle)
- Inventory Service (reserves/releases stock)
- Payment Service (authorizes/captures payments)

## Planned features (roadmap)
- REST APIs for each service
- PostgreSQL persistence + migrations
- Event-driven communication (Kafka/RabbitMQ)
- Outbox pattern (reliable event publishing)
- Saga workflow (order lifecycle across services)
- Tests (unit + integration with Testcontainers)
- CI with GitHub Actions
