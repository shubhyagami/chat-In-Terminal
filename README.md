[K[2m  [2mmodel deepseek-ai/deepseek-v4.1-flash failed, trying next...[0m[0m
# Chat‑In‑Terminal

**Chat‑In‑Terminal** is a minimal Spring Boot 3.x application that runs as both a WebSocket chat server and a terminal‑based client.  
Deploy it as a single executable JAR – it will start a server on its own or join an existing chat room from the command line.

---

## Badges

![Build](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)  
![Java 17+](https://img.shields.io/badge/Java-17%2B-brightgreen)  
![Spring Boot 3](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)  
![MIT](https://img.shields.io/badge/License-MIT-blue)  
![Tests 100%](https://img.shields.io/badge/Tests-100%25-brightgreen)  

---

## Key Features

| Feature | Description |
|--------|-------------|
| **Dual‑mode** | A single JAR acts as a WebSocket server or a terminal client based on its arguments. |
| **Room isolation** | Each room has a numeric ID; messages are scoped to that room only. |
| **Real‑time** | STOMP over WebSockets provides low‑latency communication. |
| **Persistence** | Messages are automatically stored in an embedded H2 database with timestamps. |
| **History API** | Retrieve past messages via a REST endpoint. |
| **Zero external deps** | No external database or message broker required. |

---

## Quick Start

### 1. Build

```bash
./mvnw clean package
```

### 2. Server Mode

Run the JAR without arguments – the server starts on port **8080**.

```bash
java -jar target/chat-in-terminal-*.jar
```

| Endpoint | URL |
|----------|-----|
| WebSocket | `ws://localhost:8080/ws` |
| REST API | `http://localhost:8080` |

### 3. Client Mode

Open a new terminal and supply a room URL:

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
```

- **Send**: Type a message and press `Enter`.  
- **Exit**: Press `Ctrl+C`.  

---

## Configuration

| Property | Default | Description |
|----------|---------|--------------|
| `server.port` | `8080` | Port the server listens on. |
| `spring.datasource.url` | `jdbc:h2:file:./data/chatdb` | H2 file location. |
| `spring.jpa.hibernate.ddl-auto` | `update` | Auto‑create/modify schema. |

To change the port:

```bash
java -jar target/chat-in-terminal-*.jar -Dserver.port=9090
```

---

## API Reference

### `GET /api/rooms/{roomId}/history`

Return all messages for a given room.

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

| Field | Type | Note |
|-------|------|------|
| `timestamp` | `String` | ISO‑8601 UTC |
| `author` | `String` | Sender name |
| `content` | `String` | Message text |

---

## Architecture Overview

```
Terminal (STOMP)  →  Spring Boot WebSocket  →  H2 Database
                           ↘︎ REST API ↙
```

- **`WebSocketConfig`** – sets up the `/ws` endpoint and broker.  
- **`MessageController`** – STOMP handler: persisting and broadcasting.  
- **`ChatHistoryController`** – exposes the history endpoint.  
- **`MessageRepository`** – Spring Data JPA DAO.

---

## Development

### Run Tests

```bash
./mvnw test
```

### Project Structure

```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/        # WebSocket & application config
 │   │   ├─ controller/   # REST & STOMP controllers
 │   │   └─ repository/   # JPA access
 │   └─ resources/       # application.yml, schema.sql, messages.properties
 └─ test/
     └─ java/...          # Unit & integration tests
```

### Contributing

1. Fork ➜ `git clone` ➜ `git checkout -b feature/your-feature`  
2. Add code and tests.  
3. Ensure all tests pass: `./mvnw test`  
4. Open a Pull Request to `main`.

See the [CONTRIBUTING.md](CONTRIBUTING.md) for full guidelines.

---

## License

MIT – see the [LICENSE](LICENSE) file.

---

## Changelog

| Date | Change |
|------|--------|
| 2026‑09‑24 | Updated README – improved clarity, reorganized sections, added badges. |
| 2026‑09‑19 | Added REST API documentation, restructured architecture section. |
| 2026‑09‑17 | Introduced test‑coverage badge and updated build steps. |
| 2026‑09‑04 | Expanded feature list and added history API. |
| 2026‑09‑01 | Optimized WebSocket configuration, added integration tests. |
| 2026‑08‑29 | Repository created. |

---
