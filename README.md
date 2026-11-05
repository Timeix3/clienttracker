# Client Tracker

REST API для управления клиентами. Приложение использует Spring Boot и PostgreSQL.

## Запуск через Docker Compose

Требуются установленные Docker и Docker Compose.

Из корня проекта выполните:

```bash
docker compose up --build -d
```

Compose соберёт приложение и запустит его вместе с PostgreSQL. После запуска:

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
