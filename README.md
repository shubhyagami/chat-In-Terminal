[K[2m  [2mmodel z-ai/glm-5.3-flash failed, trying next...[0m[0m
[K[2m  [2mmodel deepseek-ai/deepseek-v4.1-flash failed, trying next...[0m[0m
[K[2m  [2mmodel openai/gpt-oss-20b failed, trying next...[0m[0m
[K[2m  [2mmodel openai/gpt-oss-120b failed, trying next...[0m[0m
# Chat-In-Terminal

**Chat-In-Terminal** is a lightweight Spring Boot 3.x application that functions as both a WebSocket chat server and a terminal-based client. A single executable JAR allows you to either host a chat server or connect to an existing room directly from your command line.

---

## Badges

[![Build](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)](https://github.com/shubhyagami/chat-In-Terminal/actions)
[![Java 17+](https://img.shields.io/badge/Java-17%2B-brightgreen)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot 3](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue)](LICENSE)
[![Tests](https://img.shields.io/badge/Tests-100%25-brightgreen)](https://github.com/shubhyagami/chat-In-Terminal/actions)

---

## Features

- **Dual-Mode Execution**: Use the same JAR as a server (no arguments) or a client (provide room URL).
- **Room Isolation**: Messages are scoped to numeric room IDs to keep conversations separate.
- **Real-time Communication**: Low-latency messaging powered by STOMP over WebSockets.
- **Embedded Persistence**: Built-in H2 database stores messages with timestamps—no external database setup required.
- **History API**: Access past conversations via a simple REST endpoint.
- **Zero Dependencies**: No external message brokers or database installations needed to get started.

---

## Quick Start

### 1. Build the Project
Use the Maven wrapper to package the application:
```bash
./mvnw clean package
```
This generates a JAR file in `target/chat-in-terminal-*.jar`.

### 2. Start the Server
Run the JAR without arguments to start the server on port **8080**:
```bash
java -jar target/chat-in-terminal-*.jar
```

| Resource | Endpoint |
| :--- | :--- |
| **WebSocket** | `ws://localhost:8080/ws` |
| **REST API** | `http://localhost:8080/api` |

### 3. Join as a Client
Open a new terminal and point the JAR to a specific room URL:
```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
```
- **Send**: Type your message and press `Enter`.
- **Exit**: Press `Ctrl+C`.

---

## Configuration

You can override default settings using JVM system properties:

| Property | Default | Purpose |
| :--- | :--- | :--- |
| `server.port` | `8080` | The port the server listens on. |
| `spring.datasource.url` | `jdbc:h2:file:./data/chatdb` | Path to the embedded H2 database file. |
| `spring.jpa.hibernate.ddl-auto` | `update` | Hibernate schema generation strategy. |

**Example: Changing the port to 9090**
```bash
java -jar target/chat-in-terminal-*.jar -Dserver.port=9090
```

---

## API Reference

### Get Room History
`GET /api/rooms/{roomId}/history`

Returns a JSON array of all messages associated with the specified room.

**Example Request:**
```bash
curl http://localhost:8080/api/rooms/42/history
```

**Example Response:**
```json
[
  {
    "timestamp": "2026-09-17T12:34:56Z",
    "author": "alice",
    "content": "Hello, world!"
  }
]
```

| Field | Type | Description |
| :--- | :--- | :--- |
| `timestamp` | String | ISO-8601 UTC timestamp |
| `author` | String | Identifier of the sender |
| `content` | String | The message text |

---

## Architecture

```
Terminal (STOMP)  →  Spring Boot WebSocket  →  H2 Database
                           ↘︎ REST API ↙
```

- **`WebSocketConfig`**: Configures the `/ws` endpoint and the internal message broker.
- **`MessageController`**: Handles STOMP messages, persists them to the DB, and broadcasts them to the room.
- **`ChatHistoryController`**: Manages the REST API for retrieving message history.
- **`MessageRepository`**: Spring Data JPA interface for database operations.

---

## Development

### Testing
Run the full test suite to ensure stability:
```bash
./mvnw test
```

### Project Structure
```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/       # WebSocket & App configuration
 │   │   ├─ controller/   # REST & STOMP controllers
 │   │   └─ repository/    # JPA data access layer
 │   └─ resources/        # application.yml, schema.sql, properties
 └─ test/
     └─ java/...          # Unit & Integration tests
```

### Contributing
1. Fork the repository and create your feature branch: `git checkout -b feature/your-feature`
2. Implement your changes and add corresponding tests.
3. Verify all tests pass: `./mvnw test`
4. Submit a Pull Request against the `main` branch.

Detailed guidelines can be found in [CONTRIBUTING.md](CONTRIBUTING.md).

---

## License
Distributed under the [MIT License](LICENSE).

---

## Changelog

| Date | Change |
| :--- | :--- |
| 2026-09-26 | Polished README for better clarity and organization. |
| 2026-09-24 | Updated README with improved structure and badges. |
| 2026-09-19 | Added REST API documentation and architecture diagrams. |
| 2026-09-17 | Added test coverage badge and refined build instructions. |
| 2026-09-04 | Expanded feature list and implemented history API. |
| 2026-09-01 | Optimized WebSocket config and added integration tests. |
| 2026-08-29 | Initial repository creation. |
