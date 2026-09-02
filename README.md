# Chat‑In‑Terminal

A lightweight terminal‑based chat application that lets you create or join isolated chat rooms via shareable URLs.  
Built with Spring Boot, STOMP over WebSocket, and an H2 database for persistent chat history.

---

## Badges

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=java)](https://openjdk.org/)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

---

## Features

- **Isolated chat rooms** – each URL contains its own room ID, keeping conversations separate.
- **Real‑time messaging** – messages are pushed instantly over STOMP/WebSocket.
- **Persistent history** – all messages are stored in an H2 database and can be retrieved via a REST endpoint.
- **Future work** – avatar persistence, role‑based moderation, and file sharing.

---

## Quick Start

```bash
# Clone and build
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
./mvnw spring-boot:run
```

Open your browser at `http://localhost:8080`.  
A new room is created automatically; the URL can be shared with others to join the same session.

---

## Usage

1. **Create a room** – simply visit the base URL.  
2. **Join an existing room** – navigate to its URL (e.g., `http://localhost:8080/rooms/42`).  
3. **Send messages** – type into the terminal UI; they appear instantly in all participants' UIs.  
4. **Retrieve history** – issue a GET request to `/api/rooms/{id}/history` to fetch past messages.

---

## Environment

| Requirement | Minimum |
|--------------|--------|
| Java | 17+ |
| Maven | 3.6+ (or use `./mvnw` wrapper) |

---

## Development

```bash
# Run tests
./mvnw test
```

Feel free to fork, open issues, or submit pull requests.

---

## Changelog

- **2026‑08‑29** – Updated README wording, added installation steps, refreshed badges.

---

## License

MIT © [Shubhyagami](https://github.com/shubhyagami) – see [LICENSE](LICENSE) for details.
