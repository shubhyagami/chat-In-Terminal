# Chat‑In‑Terminal

A lightweight terminal‑based chat client backed by a Spring Boot 3.x service that uses STOMP over WebSocket and stores every message in an embedded H2 database.

![Build](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MIT License](https://img.shields.io/badge/License-MIT-yellow)
![Test Coverage](https://img.shields.io/badge/Tests-100%25-brightgreen)

---

## Table of contents

- [Getting started](#getting-started)
- [Features](#features)
- [Architecture](#architecture)
- [Usage](#usage)
  - [Running the server](#running-the-server)
  - [Joining a room from a browser](#joining-a-room-from-a-browser)
  - [Terminal client](#terminal-client)
  - [Retrieving chat history](#retrieving-chat-history)
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

Open <http://localhost:8080> in a browser. The root URL creates a new chat room automatically; the room ID is shown in the path (e.g., `/rooms/42`). Copy this URL to let others join the same conversation.

---

## Features

| Feature | Benefit |
|---------|---------|
| Dedicated rooms | Each conversation is isolated and has its own shareable URL. |
| Real‑time messaging | STOMP over WebSocket delivers messages instantly. |
| Persistent history | Messages are stored in H2 and can be fetched via a REST endpoint. |
| Extensible | The project structure and clear API make adding avatars, moderation or file sharing straightforward. |

---

## Architecture

```
Client (Web or terminal) ──► WebSocket (STOMP) ──► Spring Boot
                                  │
                                  ├─ REST /api/rooms/{id}/history
                                  └─ H2 database (single table)
```

* **WebSocket** – configured in `WebSocketConfig`; message routing handled by `MessageController`.  
* **REST** – `ChatHistoryController` exposes `/api/rooms/{id}/history`.  
* **Persistence** – `MessageRepository` persists each message to one H2 table.

---

## Usage

### Running the server

```bash
./mvnw spring-boot:run
```

The application listens on port **8080** by default.

### Joining a room from a browser

1. Visit `http://localhost:8080`.  
2. A new room will be created and its ID will appear in the URL (e.g., `/rooms/42`).  
3. Share that URL with anyone who wants to join from a different browser or device.

### Terminal client

The terminal client is bundled with the application. In a separate terminal run:

```bash
java -cp target/chat-in-terminal-1.0-SNAPSHOT.jar shubhyagami.chat.TerminalClient http://localhost:8080/rooms/42
```

You can also pass `--help` to see available command‑line options.

### Retrieving chat history

```bash
curl http://localhost:8080/api/rooms/42/history
```

Example response:

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

## API

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/rooms/{id}/history` | `GET` | Returns all messages for the specified room as a JSON array. |

The JSON object contains:

- `timestamp` – ISO‑8601 UTC timestamp of the message.
- `author` – username of the sender.
- `content` – message body.

---

## Development & testing

The project uses Maven and follows standard Spring Boot conventions.

```bash
# Run unit tests
./mvnw test
```

Feel free to:

- Add integration tests, new endpoints, or UI improvements.  
- Submit pull requests that improve test coverage or documentation.

---

## Contributing

1. Fork the repository.  
2. Create a feature branch: `git checkout -b feature/your-feature`.  
3. Commit your changes and run tests.  
4. Open a pull request against `main`.

Please refer to the [CONTRIBUTING.md](CONTRIBUTING.md) file for detailed guidelines.

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
