# Chat‑In‑Terminal

> A minimal, self‑contained Spring Boot 3.x application that can act as both a WebSocket chat server and a terminal‑based client.  
> It uses STOMP over WebSocket for real‑time messaging, stores chat history in an embedded H2 database, and exposes a small REST API for retrieving past conversations.

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

# 2️⃣ Run the server
java -jar target/chat-in-terminal-*.jar
# Default REST host: http://localhost:8080
# WebSocket endpoint: ws://localhost:8080/ws

# 3️⃣ Open a new terminal and join a room
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
# Replace "1" with any room ID; use --help for more options
```

The client reads from `stdin`. Type a message and press **Enter** to send. Press `Ctrl+C` to quit.

---

## Features

| Feature | Description |
|---------|-------------|
| **Room isolation** | Each chat room is identified by a numeric ID; messages are separated per room. |
| **Real‑time** | STOMP over WebSocket ensures low‑latency delivery. |
| **Persistence** | Messages are stored in an embedded H2 database with timestamps. |
| **History API** | `GET /api/rooms/{id}/history` returns JSON of all past messages for a room. |
| **Unified JAR** | A single executable JAR can act as server or terminal client. |
| **No external dependencies** | All components are included; no separate database or message broker installation required. |

---

## Architecture

```
Terminal (STOMP) → Spring Boot WebSocket → H2 Database
                                 ↘︎ REST API ↙
```

- **`WebSocketConfig`** – registers `/ws` and a simple message broker.  
- **`MessageController`** – receives STOMP messages, persists them, and broadcasts to the room.  
- **`ChatHistoryController`** – serves the history endpoint.  
- **`MessageRepository`** – Spring Data JPA repository for the `message` table.  

---

## Getting Started

### Prerequisites

- **JDK 17+** (OpenJDK or Oracle)
- **Maven 3.9+** (the project bundles a wrapper)

### Clone & Build

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
./mvnw clean package
```

### Running the Server

```bash
java -jar target/chat-in-terminal-*.jar
```

The server listens on port **8080** by default. Change the port:

```bash
java -jar target/chat-in-terminal-*.jar -Dserver.port=9090
```

### Joining a Room (Client Mode)

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/42
```

The client automatically connects to room **42**, shows any existing messages, and waits for user input.

#### Helpful Flags

```bash
java -jar target/chat-in-terminal-*.jar --help
```

Displays available options such as custom endpoints, logging levels, or verbosity.

### Retrieving History with `curl`

```bash
curl http://localhost:8080/api/rooms/42/history
```

Response example:

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

> Returns all messages in a room as a JSON array.

| Field | Type | Description |
|-------|------|-------------|
| `timestamp` | String (ISO‑8601 UTC) | Message creation time. |
| `author` | String | Username of the sender. |
| `content` | String | The message body. |

---

## Development

### Run Tests

```bash
./mvnw test
```

The project maintains **100 %** test coverage, verified by the CI pipeline.

### Project Layout

```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/        # WebSocket & application configuration
 │   │   ├─ controller/    # REST and STOMP handlers
 │   │   └─ repository/   # Database access
 │   └─ resources/        # application.yml and schema
 └─ test/
     └─ java/...          # JUnit & integration tests
```

### Running Locally

You can run unit tests or the application directly from IntelliJ, VS Code, or any IDE that supports Maven.

### Adding a Feature

1. Create a new feature branch: `git checkout -b feature/your-feature`  
2. Write your code and tests.  
3. Run `./mvnw test` to ensure everything passes.  
4. Open a Pull Request against `main`.

---

## Contributing

All contributions are welcome! Please read the guidelines in [`CONTRIBUTING.md`](CONTRIBUTING.md) before submitting any PRs.

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

---
