# Chat‑In‑Terminal

A lightweight terminal‑based chat client that runs against a simple Spring Boot 3.x service.  
Messages are exchanged over STOMP/​WebSocket and persisted in an embedded H2 database.

![Build Status](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MIT](https://img.shields.io/badge/License-MIT-yellow)
![Test Coverage](https://img.shields.io/badge/Tests-100%25-brightgreen)

---

## Table of contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Getting started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Clone & build](#clone--build)
  - [Run the server](#run-the-server)
  - [Browser usage](#browser-usage)
  - [Terminal client usage](#terminal-client-usage)
  - [Retrieving chat history](#retrieving-chat-history)
- [API reference](#api-reference)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)
- [Changelog](#changelog)

---

## Overview

The project exposes a single WebSocket endpoint (`/app/chat`) that clients can subscribe to.  
All messages are stored in one H2 table and can be fetched through a REST endpoint.

---

## Features

| Feature | Benefit |
|---------|---------|
| Dedicated rooms | Isolated conversations with shareable URLs |
| Real‑time messaging | STOMP over WebSocket publishes instantly |
| Persisted history | All messages are stored and queryable |
| Extendable | Clear API and modular design allow adding avatars, moderation, or file sharing |

---

## Architecture

```
Client (Web or terminal) ──► STOMP WebSocket ──► Spring Boot
                                   │
                                   ├─ REST /api/rooms/{id}/history
                                   └─ H2 (single “message” table)
```

* `WebSocketConfig` configures the STOMP endpoint.  
* `MessageController` routes chat messages.  
* `ChatHistoryController` serves the history endpoint.  
* `MessageRepository` persists to H2.

---

## Getting started

### Prerequisites

* JDK 17 or newer
* Maven 3.9+

### Clone & build

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
./mvnw clean package
```

The executable JAR is created at `target/chat-in-terminal-*.jar`.

### Run the server

```bash
./mvnw spring-boot:run
```

The application listens on **port 8080** by default.

### Browser usage

1. Open <http://localhost:8080>.  
2. A new room is created automatically; its id appears in the URL (`/rooms/42`).  
3. Share that URL – anyone who visits it will join the same conversation.

### Terminal client usage

```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/42
```

The client accepts the room URL as its first argument.  
Pass `--help` for command‑line options.

### Retrieving chat history

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

---

## API reference

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/rooms/{id}/history` | `GET` | Returns all messages for the specified room as a JSON array. |

The JSON object contains:

* `timestamp` – ISO‑8601 UTC timestamp
* `author` – sender’s username
* `content` – message body

---

## Development

The project is standard Maven + Spring Boot.  
Run unit tests with:

```bash
./mvnw test
```

Feel free to contribute additional tests, endpoints, or UI improvements.

---

## Contributing

1. Fork the repo.  
2. Create a feature branch: `git checkout -b feature/your-feature`.  
3. Commit your changes and run all tests.  
4. Open a pull request against `main`.

See the [CONTRIBUTING.md](CONTRIBUTING.md) file for guidelines.

---

## License

MIT © [Shubhyagami](https://github.com/shubhyagami).  See the [LICENSE](LICENSE) file.

---

## Changelog

| Date | Change |
|------|--------|
| 2026‑09‑04 | Updated README, added badges, reorganised sections. |
| 2026‑09‑01 | Refactored WebSocket configuration, added API docs. |
| 2026‑08‑29 | Minor README updates, added installation steps. |

---
