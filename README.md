[K[2m  [2mmodel z-ai/glm-5.3-flash failed, trying next...[0m[0m
[K[2m  [2mmodel deepseek-ai/deepseek-v4.1-flash failed, trying next...[0m[0m
# Chat‑In‑Terminal

**Chat‑In‑Terminal** is a lightweight Spring Boot 3.x application that can act both as
a WebSocket chat server and as a terminal‑based client.  
A single executable JAR lets you **host** a chat room or **join** an existing
room straight from the command line.

---

## Prerequisites

- Java 17 + (JDK or JRE)
- Maven 3.9 + (for building from source)

---

## Quick Start

> **Tip**: All commands are run from the repository root.

### 1. Build the project

```bash
./mvnw clean package
```

The generated JAR is located in `target/` as `chat-in-terminal-<version>.jar`.

### 2. Start the server

```bash
java -jar target/chat-in-terminal-*.jar
```

The server listens on `8080` by default.

| Resource | Endpoint |
| :------: | :-------: |
| WebSocket | `ws://localhost:8080/ws` |
| REST API | `http://localhost:8080/api` |

### 3. Join as a client

Open a new terminal and point the JAR at a room URL:

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
```

- **Send** a message by typing and pressing **Enter**.
- **Exit** the client with `Ctrl+C`.

The client automatically connects to the WebSocket endpoint
and displays messages from the room.

---

## Configuration

The default settings can be overridden with JVM system properties
(either before the `-jar` option or through a `--` separator).

| Property | Default | Purpose |
| :------- | :------ | :------ |
| `server.port` | `8080` | Port the server listens on |
| `spring.datasource.url` | `jdbc:h2:file:./data/chatdb` | Path to the embedded H2 database |
| `spring.jpa.hibernate.ddl-auto` | `update` | Hibernate schema generation strategy |

**Example – Change port to 9090**

```bash
java -Dserver.port=9090 -jar target/chat-in-terminal-*.jar
```

---

## API Reference

### Get Room History

`GET /api/rooms/{roomId}/history`

Returns a JSON array of all messages in the specified room.

```bash
curl http://localhost:8080/api/rooms/42/history
```

```json
[
  {
    "timestamp": "2026-09-17T12:34:56Z",
    "author": "alice",
    "content": "Hello, world!"
  }
]
```

| Field     | Type   | Description                |
| :-------- | :----- | :------------------------ |
| `timestamp` | String | ISO‑8601 UTC timestamp |
| `author`     | String | Sender identifier |
| `content`    | String | Message text |

---

## Architecture

```
Terminal (STOMP)  →  Spring Boot WebSocket  →  H2 Database
                         ↘︎ REST API ↙
```

- **`WebSocketConfig`** – configures `/ws` endpoint and broker.
- **`MessageController`** – handles STOMP messages, persists and broadcasts.
- **`ChatHistoryController`** – REST API for history retrieval.
- **`MessageRepository`** – Spring Data JPA interface.

---

## Development

### Running Tests

```bash
./mvnw test
```

### Project Layout

```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/      # WebSocket & application configuration
 │   │   ├─ controller/  # REST & STOMP controllers
 │   │   └─ repository/   # JPA repositories
 │   └─ resources/     # application.yml, schema.sql, etc.
 └─ test/
     └─ java/...       # Unit and integration tests
```

---

## Contributing

1. Fork the repository and create a feature branch:  
   `git checkout -b feature/your-feature`
2. Implement your changes and add tests.
3. Run `./mvnw test` to ensure all tests pass.
4. Submit a pull request against `main`.

See [CONTRIBUTING.md](CONTRIBUTING.md) for full guidelines.

---

## License

Distributed under the [MIT License](LICENSE).

---

## Changelog

| Date | Change |
| :--- | :--- |
| 2026‑09‑26 | Updated README for clarity and organization |
| 2026‑09‑24 | Improved build instructions and badges |
| 2026‑09‑19 | Added REST API documentation |
| 2026‑09‑17 | Added test coverage badge |
| 2026‑09‑04 | Implemented history API |
| 2026‑09‑01 | Optimized WebSocket configuration |
| 2026‑08‑29 | Repository creation |

---
