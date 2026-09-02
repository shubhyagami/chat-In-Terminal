# Chat‑In‑Terminal  

A minimal terminal‑based chat system that lets a group share a URL and converse in real time.  
The server is written in Spring Boot, communicates via STOMP over WebSocket, and keeps talks in an H2 database.

---

## 🚀 Quickstart

```bash
# Clone the repo
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal

# Run the application (uses the Maven wrapper)
./mvnw spring-boot:run
```

Open `http://localhost:8080` in a browser.  
A new room is created automatically; copy the URL to invite others.

---

## 📦 Features

| Feature | Description |
|---------|-------------|
| **Isolated rooms** | Each room has its own URL; conversations don’t mix. |
| **Real‑time chat** | Messages are pushed instantly via STOMP over WebSocket. |
| **Persistent history** | All messages are stored in an H2 database and can be fetched with the REST API. |
| **Extensible** | Architecture is ready for avatar storage, moderation roles, file sharing, etc. |

---

## 🏗️ Architecture

```
+----------------+          +-------------+          +----------------+
|  Client (Web) | <------> | WebSocket  | <------> |  Spring Boot   |
+----------------+          +-------------+          +----------------+
                                          |  
                                          | REST
                                          V
                                  +------------------+
                                  |  H2 Database     |
                                  +------------------+
```

* **WebSocket** – STOMP messages are handled by `WebSocketConfig` and `MessageController`.  
* **REST** – `ChatHistoryController` exposes `/api/rooms/{id}/history`.  
* **Persistence** – `MessageRepository` writes to a single H2 table.

---

## 🎛️ Usage

1. **Create a room** – visit the root URL (`/`).  
2. **Join a room** – open the room URL (e.g., `/rooms/42`).  
3. **Send messages** – type into the terminal interface; they appear instantly for all participants.  
4. **Download history** – `GET /api/rooms/{id}/history` returns a JSON array of past messages.

---

## ⚙️ Environment

| Requirement | Minimum |
|-------------|---------|
| **Java**   | 17+ |
| **Maven**  | 3.6+ (or use the wrapper `./mvnw`) |

---

## 🧪 Development

```bash
# Run unit tests
./mvnw test
```

The code follows standard Spring Boot conventions. Feel free to add integration tests or new features.

---

## 📄 License

MIT © [Shubhyagami](https://github.com/shubhyagami) – see the [LICENSE](LICENSE) file for details.

---

## 🔖 Badges

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=java)](https://openjdk.org/)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

---

## 📅 Changelog

| Date | Change |
|------|--------|
| 2026‑08‑29 | Minor README update, added installation steps. |
| 2026‑09‑01 | Refactored WebSocket configuration, improved API docs. |

---
