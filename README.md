# Chat‑In‑Terminal

A lightweight terminal‑based chat application that lets a group create a unique URL and converse in real time.  
The backend is a Spring Boot application that uses STOMP over WebSocket and stores all messages in an H2 database.

![Build](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg) ![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk) ![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot) ![MIT License](https://img.shields.io/badge/License-MIT-yellow)

---

## Getting Started

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
./mvnw spring-boot:run
```

Open <http://localhost:8080> in your browser. A new chat room is created automatically; copy the URL to invite others.

---

## Features

| Feature | Benefit |
|---------|---------|
| **Isolated rooms** | Each conversation has its own URL; messages never cross over. |
| **Real‑time chat** | STOMP over WebSocket pushes new messages instantly. |
| **Persistence & history** | All messages are stored in H2; retrieve them via a REST endpoint. |
| **Extensible** | Clean architecture – add avatars, moderation, file sharing, etc., with minimal effort. |

---

## Architecture

```
Client (Web) ↔ WebSocket (STOMP) ↔ Spring Boot
                               |
                               ├─ REST /api/rooms/{id}/history
                               |
                               └─ H2 Database (single table)
```

* **WebSocket** – Configured in `WebSocketConfig`; message handling is provided by `MessageController`.  
* **REST** – `ChatHistoryController` exposes `/api/rooms/{id}/history`.  
* **Persistence** – `MessageRepository` writes every message to a single H2 table.

---

## Usage

1. **Create a room** – navigate to the root URL (`/`).  
2. **Share the URL** – the room ID is part of the path (e.g., `/rooms/42`).  
3. **Join a room** – open the room URL in another browser or terminal.  
4. **Chat** – type messages in the terminal interface; they appear instantly for all participants.  
5. **Download history** –  

```bash
curl http://localhost:8080/api/rooms/42/history
```

The response is a JSON array containing all past messages for that room.

---

## Development & Testing

```bash
# Run unit tests
./mvnw test
```

The project follows standard Spring Boot conventions. Pull requests are welcome—feel free to add integration tests, new endpoints, or UI improvements.

---

## Contributing

1. Fork the repository.  
2. Create a feature branch (`git checkout -b feature/foo`).  
3. Commit your changes and run tests.  
4. Submit a pull request against `main`.

See [CONTRIBUTING.md](CONTRIBUTING.md) for more details.

---

## License

MIT © [Shubhyagami](https://github.com/shubhyagami). See the [LICENSE](LICENSE) file.

---

## Changelog

| Date | Change |
|------|--------|
| 2026‑09‑04 | Updated README, added badges, cleaned up sections. |
| 2026‑09‑01 | Refactored WebSocket configuration, improved API documentation. |
| 2026‑08‑29 | Minor README update, added installation steps. |

---
