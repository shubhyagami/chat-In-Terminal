# Chat‑In‑Terminal

*A lightweight terminal client that talks to a Spring Boot 3.x back‑end over STOMP/WebSocket.  
All chat messages are stored in an embedded H2 database and can be retrieved via a REST API.*

![Build Status](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MIT](https://img.shields.io/badge/License-MIT-yellow)
![Test Coverage 100%](https://img.shields.io/badge/Tests-100%25-brightgreen)

> **Quick start**  
> ```bash
> # Build the project
> ./mvnw clean package
> # Start the server (HTTP & WebSocket on port 8080)
> java -jar target/chat-in-terminal-*.jar
> # Connect the terminal client to a room
> java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
> ```

-------------------------------------------------------------------

## Table of contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Getting started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Build the project](#build-the-project)
  - [Run the server](#run-the-server)
  - [Use the terminal client](#use-the-terminal-client)
  - [View chat history](#view-chat-history)
- [API reference](#api-reference)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)
- [Changelog](#changelog)

-------------------------------------------------------------------

## Overview

The application serves a single WebSocket endpoint (`/app/chat`) that clients subscribe to using STOMP.  
Messages are appended to a single `message` table in an embedded H2 database and can be queried through the `/api/rooms/{id}/history` REST endpoint.

-------------------------------------------------------------------

## Features

| Feature | Description |
|---------|-------------|
| Dedicated rooms | Each room has a unique URL and holds an isolated conversation. |
| Real‑time messaging | STOMP over WebSocket delivers messages instantly. |
| Persistence | All messages are stored and time‑stamped in the database. |
| Extensible | The modular design allows easy addition of avatars, moderation, file sharing, etc. |

-------------------------------------------------------------------

## Architecture

```
Client (web or terminal)
      ──► STOMP WebSocket ──► Spring Boot
          |                       |
          ├─ REST /api/rooms/{id}/history
          └─ H2 (single “message” table)
```

| Component               | Responsibility |
|-------------------------|-----------------|
| `WebSocketConfig`      | Configures the STOMP endpoint |
| `MessageController`     | Routes chat messages |
| `ChatHistoryController`| Exposes the history API |
| `MessageRepository`   | Persists to H2 |

-------------------------------------------------------------------

## Getting started

### Prerequisites

- JDK 17 or newer
- Maven 3.9+

### Build the project

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
./mvnw clean package
```

Both the server and the terminal client are packaged into a single JAR located in `target/`.

### Run the server

```bash
java -jar target/chat-in-terminal-*.jar
```

The application listens on **port 8080** by default.

### Use the terminal client

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/42
```

The client will connect to the specified room.  
Run `java -jar target/chat-in-terminal-*.jar --help` to see available options.

### View chat history

```bash
curl http://localhost:8080/api/rooms/42/history
```

Sample response:

```json
[
  {
    "timestamp":"2026-09-05T12:34:56.789Z",
    "author":"alice",
    "content":"Hello, world!"
  }
]
```

-------------------------------------------------------------------

## API reference

| Endpoint                  | Method | Description                         |
|---------------------------|--------|-------------------------------------|
| `/api/rooms/{id}/history` | GET    | Returns all messages for the room `id` |

Response fields:

| Field     | Type   | Description            |
|-----------|--------|------------------------|
| `timestamp` | string | ISO‑8601 UTC timestamp |
| `author`    | string | Sender’s username       |
| `content`   | string | Message body            |

-------------------------------------------------------------------

## Development

Run the unit tests with:

```bash
./mvnw test
```

Feel free to add new tests, endpoints, or improve the terminal UI.  
The project uses the standard Maven lifecycle: `clean`, `install`, `package`, etc.

-------------------------------------------------------------------

## Contributing

1. Fork the repository.  
2. Create a feature branch: `git checkout -b feature/your-feature`.  
3. Commit changes and make sure all tests pass.  
4. Open a pull request against `main`.

See the [CONTRIBUTING.md](CONTRIBUTING.md) file for detailed guidelines.

-------------------------------------------------------------------

## License

MIT © [Shubhyagami](https://github.com/shubhyagami).  
See the [LICENSE](LICENSE) file.

-------------------------------------------------------------------

## Changelog

| Date       | Change |
|------------|--------|
| 2026-09-04 | Updated README, added badges, reorganised sections |
| 2026-09-01 | Refactored WebSocket configuration, added API docs |
| 2026-08-29 | Minor README updates, added installation steps |
