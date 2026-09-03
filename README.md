# Chat‑In‑Terminal

A lightweight, terminal‑based chat system that lets a group share a unique URL and converse in real time.  
The server is a Spring Boot application that communicates via STOMP over WebSocket and persists messages in an H2 database.

---

## 🔍 Quick Overview

| Feature | What it gives you |
|--------|-------------------|
| **Isolated rooms** | Each conversation has its own URL, so messages never mix. |
| **Instant messaging** | STOMP over WebSocket pushes messages as soon as they are sent. |
| **History** | All messages are stored in H2 and can be fetched with a simple REST endpoint. |
| **Open‑ended architecture** | Designed to be extended with avatars, moderation, file drops, etc. |

---

## 🏗️ Architecture

```
Client (Web) ↔ WebSocket (STOMP) ↔ Spring Boot
                                 ^
                                 |
                         REST /api/rooms/{id}/history
                                 |
                          H2 Database (single table)
```

* **WebSocket** – Handled by `WebSocketConfig` and `MessageController`.  
* **REST** – `ChatHistoryController` exposes `/api/rooms/{id}/history`.  
* **Persistence** – `MessageRepository` writes all messages to one H2 table.

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or newer
- Maven 3.6+ (or use the included wrapper `./mvnw`)

### Installation

```bash
# Clone the repository
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
```

### Running the application

```bash
# Use the Maven wrapper
./mvnw spring-boot:run
```

Open `http://localhost:8080` in your browser.  
A new room is created automatically; copy the URL to invite others.

---

## 📘 Using the Application

1. **Create a room** – Navigate to the root URL (`/`).  
2. **Share the URL** – The URL contains the room ID (e.g., `/rooms/42`).  
3. **Join a room** – Open the room URL.  
4. **Chat** – Type into the terminal interface; messages appear instantly for all participants.  
5. **Download history** –  
   ```bash
   curl -X GET http://localhost:8080/api/rooms/42/history
   ```  
   The response is a JSON array of past messages.

---

## 🧪 Development & Testing

```bash
# Run unit tests
./mvnw test
```

The project follows standard Spring Boot conventions. Contributions are welcome—feel free to add integration tests or new features.

---

## 📄 License

MIT © [Shubhyagami](https://github.com/shubhyagami) – see the [LICENSE](LICENSE) file.

---

## 🏷️ Badges

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
