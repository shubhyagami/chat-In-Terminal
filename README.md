# Chat‑In‑Terminal

A lightweight chat application that runs in your terminal.  
The backend is a Spring Boot 3.x service that communicates over STOMP over WebSocket and persists every message in an embedded H2 database.

![Build](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg) ![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk) ![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot) ![MIT License](https://img.shields.io/badge/License-MIT-yellow)

---

## Table of contents

- [Getting started](#getting-started)
- [Features](#features)
- [Architecture](#architecture)
- [Usage](#usage)
- [API](#api)
- [Development & testing](#development--testing)
- [Contributing](#contributing)
- [License](#license)
- [Changelog](#changelog)

---

## Getting started

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
./mvnw spring-boot:run
```

Open <http://localhost:8080> in your browser. A fresh chat room is created automatically; copy the URL to add participants.

---

## Features

| Feature | Why it matters |
|---------|----------------|
| **Dedicated rooms** | Each conversation has its own URL; messages are isolated. |
| **Real‑time chat** | STOMP over WebSocket pushes new messages instantly. |
| **Persistent history** | All messages are stored in H2; retrieve them via a REST endpoint. |
| **Extensible** | Clean codebase – add avatars, moderation, file sharing, etc., with minimal effort. |

---

## Architecture

```
Client (Web) ──► WebSocket (STOMP) ──► Spring Boot
                                   │
                                   ├─ REST /api/rooms/{id}/history
                                   └─ H2 database (single table)
```

* **WebSocket** – configured in `WebSocketConfig`; message routing handled by `MessageController`.  
* **REST** – `ChatHistoryController` exposes `/api/rooms/{id}/history`.  
* **Persistence** – `MessageRepository` writes every message to a single H2 table.

---

## Usage

1. **Create a room** – go to the root URL (`/`).  
2. **Share the URL** – the room ID is part of the path (e.g., `/rooms/42`).  
3. **Join a room** – open the room URL in another browser or terminal.  
4. **Chat** – type messages in the terminal interface; they appear immediately for all participants.  
5. **Download history** –  

```bash
curl http://localhost:8080/api/rooms/42/history
```

The response is a JSON array of all past messages for that room.

---

## API

| Endpoint | Method | Description |
|----------|-------|-------------|
| `/api/rooms/{id}/history` | `GET` | Return an array of all messages for the specified room. |

The response format:

```json
[
  {
    "timestamp": "2026-09-05T12:34:56.789Z",
    "author": "alice",
    "content": "Hello, world!"
  },
  …
]
```

---

## Development & testing

Run unit tests with:

```bash
./mvnw test
```

The project follows standard Spring Boot conventions. Pull requests adding integration tests, new endpoints, or UI improvements are welcome.

---

## Contributing

1. Fork the repository.  
2. Create a feature branch: `git checkout -b feature/add‑foo`.  
3. Commit your changes and run tests.  
4. Open a pull request against `main`.

See the [CONTRIBUTING.md](CONTRIBUTING.md) file for detailed guidelines.

---

## License

MIT © [Shubhyagami](https://github.com/shubhyagami). See the [LICENSE](LICENSE) file for details.

---

## Changelog

| Date | Change |
|------|--------|
| 2026‑09‑04 | Updated README, added badges, reorganised sections. |
| 2026‑09‑01 | Refactored WebSocket configuration, added API docs. |
| 2026‑08‑29 | Minor README updates, added installation steps. |

---
