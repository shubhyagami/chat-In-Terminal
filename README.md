# Chat‑In‑Terminal

A lightweight, terminal‑based chat client that talks to a simple Spring Boot 3.x service.  
Messages are sent over STOMP/WebSocket and persisted in an embedded H2 database.  

![Build Status](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)  
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)  
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)  
![MIT](https://img.shields.io/badge/License-MIT-yellow)  
![Test Coverage](https://img.shields.io/badge/Tests-100%25-brightgreen)

> Quick start:  
> ```bash
> # build the server
> ./mvnw clean package
> # run the server
> java -jar target/chat-in-terminal-*.jar
> # run the client for a room at http://localhost:8080/rooms/1
> java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
> ```

---

## Table of contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Getting started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Build the project](#build-the-project)
  - [Run the server](#run-the-server)
  - [Use in a browser](#use-in-a-browser)
  - [Use the terminal client](#use-the-terminal-client)
  - [Retrieve chat history](#retrieve-chat-history)
- [API reference](#api-reference)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)
- [Changelog](#changelog)

---

## Overview

The application exposes a single WebSocket endpoint (`/app/chat`) that clients can subscribe to.  
All messages are stored in a single `message` table inside an H2 database and can be fetched via a REST endpoint.

---

## Features

- **Dedicated rooms** – Isolated conversations, shareable URLs
- **Real‑time messaging** – STOMP over WebSocket publishes instantly
- **Persisted history** – All messages are stored and queryable
- **Extensible** – Clear API and modular design make it easy to add avatars, moderation, file sharing, etc.

---

## Architecture

```
Client (Web or terminal) ──► STOMP WebSocket ──► Spring Boot
                                   │
                                   ├─ REST /api/rooms/{id}/history
                                   └─ H2 (single “message” table)
```

| Component | Responsibility |
|-----------|----------------|
| `WebSocketConfig` | Configures the STOMP endpoint |
| `MessageController` | Routes chat messages |
| `ChatHistoryController` | Serves the history endpoint |
| `MessageRepository` | Persists to H2 |

---

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

The executable JAR is located at `target/chat-in-terminal-*.jar`.

### Run the server

```bash
java -jar target/chat-in-terminal-*.jar
```

The application listens on **port 8080** by default.

### Use in a browser

1. Open <http://localhost:8080>.  
2. A new room is created automatically; its id appears in the URL (`/rooms/42`).  
3. Share that URL – anyone who visits it will join the same conversation.

### Use the terminal client

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/42
```

The client accepts the room URL as its first argument.  
Run `java -jar ... --help` for command‑line options.

### Retrieve chat history

```bash
curl http://localhost:8080/api/rooms/42/history
```

Typical response:

```json
[
  {
    "timestamp":"2026-09-05T12:34:56.789Z",
    "author":"alice",
    "content":"Hello, world!"
  }
]
```

---

## API reference

| Endpoint | Method | Description |
|----------|--------|--------------|
| `/api/rooms/{id}/history` | `GET` | Returns all messages for the specified room as a JSON array |

The JSON object contains:

- `timestamp` – ISO‑8601 UTC timestamp
- `author` – sender’s username
- `content` – message body

---

## Development

The project is a standard Maven + Spring Boot application.

```bash
# run unit tests
./mvnw test
```

Feel free to add tests, endpoints, or UI enhancements.

---

## Contributing

1. Fork the repository.  
2. Create a feature branch: `git checkout -b feature/your-feature`.  
3. Commit your changes and run all tests.  
4. Open a pull request against `main`.

See the [CONTRIBUTING.md](CONTRIBUTING.md) file for detailed guidelines.

---

## License

MIT © [Shubhyagami](https://github.com/shubhyagami).  
See the [LICENSE](LICENSE) file.

---

## Changelog

| Date | Change |
|------|--------|
| 2026‑09‑04 | Updated README, added badges, reorganised sections |
| 2026‑09‑01 | Refactored WebSocket configuration, added API docs |
| 2026‑08‑29 | Minor README updates, added installation steps |

---
