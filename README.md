# Chat-In-Terminal

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue)

**Chat-In-Terminal** is a lightweight Spring Boot 3.x application that runs as both a WebSocket chat server and a terminal-based chat client. One executable JAR is all you need to host a new chat room or join an existing one — everything happens from the command line.

## Features

- Server and client packaged in a single executable JAR
- STOMP messaging over WebSocket
- Message history persisted to an embedded H2 database
- REST endpoint for retrieving room history
- Runs with nothing more than a JDK — no external services required

## Prerequisites

- Java 17 or newer (JDK or JRE)
- Maven 3.9+ (only for building from source; the Maven wrapper is included)

## Getting Started

> All commands below are run from the repository root.

### 1. Build the project

```bash
./mvnw clean package
```

The executable JAR is written to `target/chat-in-terminal-<version>.jar`.

### 2. Start the server

```bash
java -jar target/chat-in-terminal-*.jar
```

The server listens on port `8080` by default.

| Resource  | Endpoint                    |
| --------- | --------------------------- |
| WebSocket | `ws://localhost:8080/ws`    |
| REST API  | `http://localhost:8080/api` |

### 3. Join as a client

Open a second terminal and point the JAR at a room URL:

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
```

- Type a message and press **Enter** to send it.
- Press **Ctrl+C** to exit.

The client connects to the room's WebSocket endpoint and prints incoming messages to the terminal.

## Configuration

Defaults can be overridden with JVM system properties — place them before the `-jar` option, or after a `--` separator.

| Property | Default | Description |
| -------- | ------- | ----------- |
| `server.port` | `8080` | Port the server listens on |
| `spring.datasource.url` | `jdbc:h2:file:./data/chatdb` | Path to the embedded H2 database |
| `spring.jpa.hibernate.ddl-auto` | `update` | Hibernate schema generation strategy |

Example — run the server on port 9090:

```bash
java -Dserver.port=9090 -jar target/chat-in-terminal-*.jar
```

## API Reference

### Get room history

```
GET /api/rooms/{roomId}/history
```

Returns a JSON array with all messages in the given room.

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

| Field       | Type   | Description            |
| ----------- | ------ | ---------------------- |
| `timestamp` | String | ISO-8601 UTC timestamp |
| `author`    | String | Sender identifier      |
| `content`   | String | Message text           |

## Architecture

```
Terminal (STOMP)  →  Spring Boot WebSocket  →  H2 Database
                          ↘ REST API ↙
```

| Component | Role |
| --------- | ---- |
| `WebSocketConfig` | Configures the `/ws` endpoint and message broker |
| `MessageController` | Handles STOMP messages; persists and broadcasts them |
| `ChatHistoryController` | REST API for history retrieval |
| `MessageRepository` | Spring Data JPA interface |

## Development

### Running tests

```bash
./mvnw test
```

### Project layout

```text
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/       # WebSocket & application configuration
 │   │   ├─ controller/   # REST & STOMP controllers
 │   │   └─ repository/   # JPA repositories
 │   └─ resources/        # application.yml, schema.sql, etc.
 └─ test/
     └─ java/...          # Unit and integration tests
```

## Contributing

1. Fork the repository and create a feature branch:
   `git checkout -b feature/your-feature`
2. Implement your changes and add tests.
3. Run `./mvnw test` and make sure everything passes.
4. Open a pull request against `main`.

See [CONTRIBUTING.md](CONTRIBUTING.md) for the full guidelines.

## License

Distributed under the [MIT License](LICENSE).

## Changelog

| Date | Change |
| ---- | ------ |
| 2026-09-30 | Rewrote README: clearer structure, fixed typos, added badges and feature list |
| 2026-09-26 | Updated README for clarity and organization |
| 2026-09-24 | Improved build instructions and badges |
| 2026-09-19 | Added REST API documentation |
| 2026-09-17 | Added test coverage badge |
| 2026-09-04 | Implemented history API |
| 2026-09-01 | Optimized WebSocket configuration |
| 2026-08-29 | Repository creation |
