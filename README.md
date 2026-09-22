# Chat‑In‑Terminal

*A lightweight Spring Boot 3.x application that can act as both a WebSocket chat server and a terminal‑based client.*

This project ships as a single executable JAR.  
Run it in “server mode” to start the chat service, or pass a room URL to run it in “client mode” and join a chat room directly from your terminal.

---

## Badges

![Build Status](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MIT License](https://img.shields.io/badge/License-MIT-yellow)
![Test Coverage](https://img.shields.io/badge/Tests-100%25-brightgreen)

---

## Quick Start

```bash
# 1️⃣ Build the project
./mvnw clean package

# 2️⃣ Run the server (default port 8080)
java -jar target/chat-in-terminal-*.jar
# WebSocket endpoint: ws://localhost:8080/ws
# REST API: http://localhost:8080

# 3️⃣ Open a new terminal and join a room
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
```

The client reads from `stdin`. Type a message and press **Enter** to send. Exit with `Ctrl+C`.

---

## Features

- **Room isolation** – Numeric room IDs keep conversations separate.  
- **Real‑time delivery** – STOMP over WebSocket gives low‑latency messaging.  
- **Persistence** – All messages are stored in an embedded H2 database with timestamps.  
- **History API** – `GET /api/rooms/{id}/history` returns JSON of past messages.  
- **Single executable** – One JAR can act as server or terminal client.  
- **Zero external services** – No separate DB or broker required.

---

## Architecture

```
Terminal (STOMP) → Spring Boot WebSocket → H2 Database
                                     ↘︎ REST API ↙
```

- **`WebSocketConfig`** – registers `/ws` and a simple message broker.  
- **`MessageController`** – handles STOMP messages, persists them, and broadcasts to the room.  
- **`ChatHistoryController`** – exposes the history endpoint.  
- **`MessageRepository`** – Spring Data JPA repository for the `message` table.

---

## Getting Started

### Prerequisites

- **JDK 17+** (OpenJDK or Oracle)
- **Maven 3.9+** (the wrapper is included)

### Clone and Build

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
./mvnw clean package
```

### Run the Server

```bash
java -jar target/chat-in-terminal-*.jar
```

Change the port if needed:

```bash
java -jar target/chat-in-terminal-*.jar -Dserver.port=9090
```

### Join a Room (Client Mode)

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/42
```

The client automatically:

1. Connects to room **42**.  
2. Displays any existing messages.  
3. Waits for user input.

#### Common Flags

```
java -jar target/chat-in-terminal-*.jar --help
```

Shows options such as custom endpoints, logging levels, and verbosity.

### Retrieve History with `curl`

```bash
curl http://localhost:8080/api/rooms/42/history
```

Example response:

```json
[
  {
    "timestamp": "2026-09-17T12:34:56Z",
    "author": "alice",
    "content": "Hello, world!"
  }
]
```

---

## API Reference

### `GET /api/rooms/{id}/history`

Returns all messages in the specified room as a JSON array.

| Field     | Type                    | Description                        |
|-----------|------------------------|------------------------------------|
| `timestamp` | String (ISO‑8601 UTC)  | Message creation time.            |
| `author`   | String                | Username of the sender.            |
| `content`  | String                | The message body.                  |

---

## Development

### Run Tests

```bash
./mvnw test
```

The CI pipeline verifies **100 %** coverage.

### Project Layout

```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/        # WebSocket & application configuration
 │   │   ├─ controller/    # REST and STOMP handlers
 │   │   └─ repository/    # Database access
 │   └─ resources/        # application.yml and schema
 └─ test/
     └─ java/...          # JUnit & integration tests
```

### IDEs

The project is configured for Maven. Open it in IntelliJ, VS Code, or any IDE that supports Maven to run the application or tests directly.

### Adding a Feature

1. Create a feature branch: `git checkout -b feature/your-feature`  
2. Write code and tests.  
3. Run `./mvnw test` to confirm all tests pass.  
4. Open a Pull Request against `main`.

---

## Contributing

All contributions are welcome. See [`CONTRIBUTING.md`](CONTRIBUTING.md) for guidelines before creating a PR.

---

## License

Distributed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Changelog

| Date | Change |
|------|--------|
| 2026‑09‑19 | Clarified README structure and added badges. |
| 2026‑09‑17 | Updated documentation and introduced code‑coverage badge. |
| 2026‑09‑04 | Added REST API docs and expanded architecture section. |
| 2026‑09‑01 | Refined WebSocket config and added tests. |
| 2026‑08‑29 | Initial repository creation. |
