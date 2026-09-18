# Chat‑In‑Terminal

Chat‑In‑Terminal is a lightweight command‑line chat client backed by a Spring Boot 3.x server.  
It uses STOMP over WebSocket for real‑time messaging and stores all chat history in an
embedded H2 database, which can be queried through a simple REST API.

![Build Status](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MIT](https://img.shields.io/badge/License-MIT-yellow)
![Test Coverage](https://img.shields.io/badge/Tests-100%25-brightgreen)

## Quick Start

```bash
# 1. Build the project (both server and client are bundled in a single JAR)
./mvnw clean package

# 2. Start the server
java -jar target/chat-in-terminal-*.jar
#    └─ http://localhost:8080    (REST)   /api/rooms/{id}/history
#    └─ ws://localhost:8080/ws   (WebSocket)

# 3. Connect the terminal client to a room
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
#    └─ Replace 1 with any room ID
#    └─ Use --help to see available flags
```

The client reads messages from `stdin`. Type a line and press **Enter** to send it.

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [API Reference](#api-reference)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)
- [Changelog](#changelog)

## Features

- **Room isolation** – each chat room has its own ID and private history.
- **Real‑time delivery** – STOMP over WebSocket ensures instant messaging.
- **Persisted history** – all messages are stored with timestamps in H2.
- **REST endpoint** – retrieve chat history asynchronously.
- **Single‑jar distribution** – run `java -jar` for both server and client.

## Architecture

```
Client (Terminal)  →  STOMP WebSocket  →  Spring Boot  →  H2 Database
```

### Key Components

| Component | Responsibility |
|-----------|----------------|
| `WebSocketConfig` | Defines `/ws` endpoint and broker destinations. |
| `MessageController` | Handles inbound STOMP messages and pushes them to the broker. |
| `ChatHistoryController` | Exposes `/api/rooms/{id}/history` for retrieving past messages. |
| `MessageRepository` | DAO for CRUD on the `message` table. |

## Getting Started

### Prerequisites

- JDK 17 or newer
- Maven 3.9+

### Installation

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
./mvnw clean package
```

### Running the Server

```bash
java -jar target/chat-in-terminal-*.jar
```

The server listens on **http://localhost:8080** by default.  
You can change the port with the standard Spring Boot property: `-Dserver.port=9090`.

### Joining a Chat Room

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/42
```

- `42` is an arbitrary room ID.  
- The client will connect, display incoming messages, and wait for input.

### Fetching History

```bash
curl http://localhost:8080/api/rooms/42/history
```

The response is a JSON array of messages.

## API Reference

### GET `/api/rooms/{id}/history`

Returns all messages for the specified room.

```json
[
  {
    "timestamp": "2026-09-17T12:34:56Z",
    "author": "alice",
    "content": "Hello, world!"
  },
  ...
]
```

> **Fields**
> - `timestamp` – ISO‑8601 UTC string.
> - `author` – sender’s username.
> - `content` – message body.

## Development

All tests run with Maven:

```bash
./mvnw test
```

The build pipeline ensures 100 % test coverage and generates coverage reports.

### Code Layout

```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/WebSocketConfig.java
 │   │   ├─ controller/MessageController.java
 │   │   ├─ controller/ChatHistoryController.java
 │   │   └─ repository/MessageRepository.java
 │   └─ resources/
 │       └─ application.yml
 └─ test/
     └─ java/com/example/chat/
```

Feel free to add new endpoints, extend the client UI, or improve the persistence layer.

## Contributing

1. Fork the repo.
2. Create a feature branch: `git checkout -b feature/your-feature`.
3. Commit changes and run `./mvnw test` – all tests must pass.
4. Submit a Pull Request against the `main` branch.

See **CONTRIBUTING.md** for detailed guidelines.

## License

Distributed under the MIT License. See [LICENSE](LICENSE) for details.

## Changelog

| Date       | Change |
|------------|--------|
| 2026-09-17 | Polished README and added badges. |
| 2026-09-04 | Introduced API docs and improved architecture section. |
| 2026-09-01 | Re‑worked WebSocket configuration; added test coverage badge. |
| 2026-08-29 | Initial repository creation. |
