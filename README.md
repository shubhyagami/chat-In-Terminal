# Chat‑In‑Terminal

A lightweight terminal‑based chat client backed by a Spring Boot 3.x service that uses STOMP over WebSocket and stores every message in an embedded H2 database.

![Build](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MIT License](https://img.shields.io/badge/License-MIT-yellow)

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

Open <http://localhost:8080> in a browser. A fresh chat room is created automatically; simply copy the URL to add participants. The same URL works from any terminal client.

---

## Features

| Feature | Why it matters |
|---------|----------------|
| **Dedicated rooms** | Conversations are isolated; each has its own URL. |
| **Real‑time messaging** | STOMP over WebSocket guarantees instant delivery. |
| **Persistent history** | Messages are stored in H2 and can be requested via a REST endpoint. |
| **Extensible design** | Clean code and clear API make adding avatars, moderation, or file sharing straightforward. |

---

## Architecture

```
Client (Web or terminal) ──► WebSocket (STOMP) ──► Spring Boot
                                │
                                ├─ REST /api/rooms/{id}/history
                                └─ H2 database (single table)

```

- **WebSocket** – configured in `WebSocketConfig`; routing handled by `MessageController`.  
- **REST** – `ChatHistoryController` exposes `/api/rooms/{id}/history`.  
- **Persistence** – `MessageRepository` writes each message to one H2 table.

---

## Usage

1. **Create a room** – navigate to the root URL (`/`).  
2. **Share the URL** – the room ID appears in the path (e.g., `/rooms/42`).  
3. **Join a room** – open the same URL in another browser or terminal.  
4. **Chat** – type messages and hit *Enter*; they appear instantly for all participants.  
5. **Download history** – retrieve a room’s history as JSON:

   ```bash
   curl http://localhost:8080/api/rooms/42/history
   ```

   Example response:

   ```json
   [
     {
       "timestamp": "2026-09-05T12:34:56.789Z",
       "author": "alice",
       "content": "Hello, world!"
     }
   ]
   ```

---

## API

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/rooms/{id}/history` | `GET` | Returns all messages for the specified room. |

The response is a JSON array of message objects with `timestamp`, `author`, and `content` fields.

---

## Development & testing

The project follows standard Spring Boot conventions.

```bash
# Run unit tests
./mvnw test
```

Feel free to add integration tests, new endpoints, or UI improvements. Pull requests that improve test coverage or documentation are especially welcome.

---

## Contributing

1. Fork the repository.  
2. Create a feature branch: `git checkout -b feature/add‑foo`.  
3. Commit your changes and run tests.  
4. Open a pull request against `main`.

Detailed guidelines are in the [CONTRIBUTING.md](CONTRIBUTING.md) file.

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
