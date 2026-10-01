[K[2m  [2mmodel z-ai/glm-5.3-flash failed, trying next...[0m[0m
[K[2m  [2mmodel deepseek-ai/deepseek-v4.1-flash failed, trying next...[0m[0m
# Chat‑In‑Terminal

> A tiny Spring Boot 3.x application that works both as a WebSocket chat server and a terminal client.  
> Run it once and you can host or join chat rooms from the command line without any external services.

![Java 17](https://img.shields.io/badge/Java-17-orange?logo=openjdk&logoColor=white)  
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot&logoColor=white)  
![MIT License](https://img.shields.io/badge/License-MIT-blue)  
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)

---

## Features

* Single executable JAR that contains both server and client
* STOMP over WebSocket for real‑time messaging
* Persistent chat history in an embedded H2 database
* REST endpoint to fetch room history
* Zero runtime dependencies – just a JDK

---

## Prerequisites

| Tool | Minimum version |
|------|-----------------|
| Java JDK | 17 or newer |
| Maven | 3.9+ (the wrapper is included) |

---

## Quick Start

> All commands are executed from the repository root.

### 1. Build the project

```bash
./mvnw clean package
```

The JAR is produced at `target/chat-in-terminal-<version>.jar`.

### 2. Run the server

```bash
java -jar target/chat-in-terminal-*.jar
```

The server listens on **port 8080** by default.

| Resource | URL |
|----------|-----|
| WebSocket | `ws://localhost:8080/ws` |
| REST API | `http://localhost:8080/api` |

### 3. Join as a client

Open a new terminal and point the JAR at a room URL:

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
```

* Type a message and press **Enter** to send.
* Press **Ctrl + C** to exit.

The client connects to the room’s WebSocket endpoint and prints incoming messages to the terminal.

---

## Configuration

Override defaults with JVM system properties. Specify them *before* the `-jar` option or after `--`.

| Property | Default | Purpose |
|----------|---------|---------|
| `server.port` | `8080` | Port the server listens on |
| `spring.datasource.url` | `jdbc:h2:file:./data/chatdb` | Path to the embedded H2 database |
| `spring.jpa.hibernate.ddl-auto` | `update` | Hibernate schema generation strategy |

Example – run the server on port 9090:

```bash
java -Dserver.port=9090 -jar target/chat-in-terminal-*.jar
```

---

## API Reference

### Retrieve room history

```
GET /api/rooms/{roomId}/history
```

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

| Field     | Type   | Description |
|-----------|--------|-------------|
| `timestamp` | String | ISO‑8601 UTC timestamp |
| `author`     | String | Sender identifier |
| `content`    | String | Message text |

---

## Architecture

```
Terminal (STOMP)  →  Spring Boot WebSocket  →  H2 Database
                               ↘ REST API ↙
```

| Component | Role |
|------------|------|
| `WebSocketConfig` | Registers `/ws` and the message broker |
| `MessageController` | Handles STOMP messages, persists and broadcasts |
| `ChatHistoryController` | Exposes REST endpoint for history |
| `MessageRepository` | Spring Data JPA repository |

---

## Development

### Run tests

```bash
./mvnw test
```

### Project layout

```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/       # WebSocket & application config
 │   │   ├─ controller/   # REST & STOMP controllers
 │   │   └─ repository/   # JPA repositories
 │   └─ resources/        # application.yml, schema.sql, etc.
 └─ test/
     └─ java/...          # Unit and integration tests
```

---

## Contributing

1. Fork the repository and create a feature branch:  
   `git checkout -b feature/your-feature`
2. Implement the change and add tests.
3. Run `./mvnw test` to ensure everything passes.
4. Open a pull request against `main`.

See the complete guidelines in [CONTRIBUTING.md](CONTRIBUTING.md).

---

## License

Distributed under the [MIT License](LICENSE).

---

## Changelog

| Date | Change |
|------|--------|
| 2026‑10‑02 | Minor README cleanup and typo fixes |
| 2026‑09‑30 | Rewrote README – clearer structure, added badges and feature list |
| 2026‑09‑26 | Updated for clarity and organization |
| 2026‑09‑23 | Improved build instructions and added badges |
| 2026‑09‑19 | Added REST API documentation |
| 2026‑09‑04 | Implemented history API |
| 2026‑09‑01 | Optimized WebSocket configuration |
| 2026‑08‑29 | Repository creation |
