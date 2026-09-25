[K[2m  [2mmodel deepseek-ai/deepseek-v4.1-flash failed, trying next...[0m[0m
# Chat‑In‑Terminal

**Chat‑In‑Terminal** is a lightweight Spring Boot 3.x application that works both as a WebSocket chat server and as a terminal‑based client.  
A single executable JAR can either start a server on its own or connect to an existing chat room from the command line.

---

## Badges

[![Build](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)](https://github.com/shubhyagami/chat-In-Terminal/actions)
[![Java 17+](https://img.shields.io/badge/Java-17%2B-brightgreen)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot 3](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![MIT](https://img.shields.io/badge/License-MIT-blue)](LICENSE)
[![Tests 100 %](https://img.shields.io/badge/Tests-100%25-brightgreen)](https://github.com/shubhyagami/chat-In-Terminal/actions)

---

## Features

| Feature | Description |
| -------- | ------------ |
| **Dual mode** | The same JAR functions as a server (no arguments) or as a client (room URL supplied). |
| **Room isolation** | Messages are scoped to a numeric room ID, keeping conversations separate. |
| **Low latency** | Uses STOMP over WebSockets for real–time communication. |
| **Embedded persistence** | Messages are stored in an H2 database with timestamps; no external DB needed. |
| **History API** | Retrieve past messages via a simple REST endpoint. |
| **Zero external deps** | No external message broker or database required. |

---

## Quick start

### 1. Build the project

```bash
./mvnw clean package
```

This creates a `target/chat-in-terminal-*.jar` file.

### 2. Run as a server

```bash
java -jar target/chat-in-terminal-*.jar
```

The server listens on port **8080** by default.

| Resource | URL |
| -------- | --- |
| WebSocket | `ws://localhost:8080/ws` |
| REST API | `http://localhost:8080/api` |

### 3. Run as a client

Open a second terminal and point the JAR at a room URL:

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
```

* Type a message and hit **Enter** to send.
* Exit with **Ctrl+C**.

---

## Configuration

| Property | Default | Purpose |
| -------- | ------- | ------- |
| `server.port` | `8080` | Port where the server listens. |
| `spring.datasource.url` | `jdbc:h2:file:./data/chatdb` | Location of the embedded H2 database. |
| `spring.jpa.hibernate.ddl-auto` | `update` | Schema auto‑generation strategy. |

To change the port, use:

```bash
java -jar target/chat-in-terminal-*.jar -Dserver.port=9090
```

---

## API Reference

### `GET /api/rooms/{roomId}/history`

Returns all messages for the specified room.

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

| Field     | Type   | Notes               |
| --------- | ------ | ------------------- |
| `timestamp` | string | ISO‑8601 UTC       |
| `author`   | string | Sender identifier   |
| `content` | string | Message text        |

---

## Architecture

```
Terminal (STOMP)  →  Spring Boot WebSocket  →  H2 Database
                           ↘︎ REST API ↙
```

* **`WebSocketConfig`** – registers the `/ws` endpoint and configures the message broker.  
* **`MessageController`** – STOMP handler that persists and broadcasts messages.  
* **`ChatHistoryController`** – exposes the history endpoint.  
* **`MessageRepository`** – Spring Data JPA DAO for `Message` entities.

---

## Development

### Run the test suite

```bash
./mvnw test
```

### Project layout

```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/        # WebSocket & application config
 │   │   ├─ controller/    # REST & STOMP controllers
 │   │   └─ repository/   # JPA access
 │   └─ resources/        # application.yml, schema.sql, messages.properties
 └─ test/
     └─ java/...          # Unit & integration tests
```

### Contributing

1. Fork ➜ `git clone` ➜ `git checkout -b feature/your-feature`  
2. Add code and tests.  
3. Ensure all tests pass: `./mvnw test`  
4. Open a Pull Request against `main`.

See the [CONTRIBUTING.md](CONTRIBUTING.md) file for detailed guidelines.

---

## License

[MIT](LICENSE)

---

## Changelog

| Date | Change |
| ---- | ------ |
| 2026‑09‑24 | Updated README – improved clarity, reorganized sections, added badges. |
| 2026‑09‑19 | Added REST API documentation, reorganized architecture section. |
| 2026‑09‑17 | Added test‑coverage badge, updated build steps. |
| 2026‑09‑04 | Expanded feature list, added history API. |
| 2026‑09‑01 | Optimized WebSocket configuration, added integration tests. |
| 2026‑08‑29 | Repository created. |

---
