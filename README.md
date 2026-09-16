[K[2m  [2mmodel openai/gpt-oss-20b failed, trying next...[0m[0m
[K[2m  [2mmodel openai/gpt-oss-120b failed, trying next...[0m[0m
# Chat-In-Terminal

A lightweight terminal-based chat client powered by a Spring Boot 3.x backend. This project utilizes STOMP over WebSockets for real-time communication and an embedded H2 database for persistent message storage.

![Build Status](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MIT](https://img.shields.io/badge/License-MIT-yellow)
![Test Coverage](https://img.shields.io/badge/Tests-100%25-brightgreen)

## Quick Start

```bash
# Build the project
./mvnw clean package

# Start the server (HTTP & WebSocket on port 8080)
java -jar target/chat-in-terminal-*.jar

# Connect the terminal client to a specific room
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
```

---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [API Reference](#api-reference)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)
- [Changelog](#changelog)

---

## Overview

Chat-In-Terminal provides a simple way to host and join chat rooms directly from the command line. The server exposes a single WebSocket endpoint (`/app/chat`) for real-time messaging via STOMP. All conversations are persisted in an H2 database and can be retrieved asynchronously via a REST API.

## Features

- **Isolated Chat Rooms**: Each room is identified by a unique ID, ensuring separate conversation threads.
- **Real-Time Delivery**: Low-latency messaging powered by STOMP over WebSockets.
- **Message Persistence**: All messages are timestamped and stored in an embedded database.
- **Modular Design**: Easily extensible architecture for adding features like user avatars, moderation, or file sharing.

## Architecture

### Data Flow
`Client (Terminal/Web)` $\rightarrow$ `STOMP WebSocket` $\rightarrow$ `Spring Boot` $\rightarrow$ `H2 Database`

### Component Breakdown
| Component | Responsibility |
| :--- | :--- |
| `WebSocketConfig` | Handles STOMP endpoint and broker configuration. |
| `MessageController` | Manages incoming chat messages and routing. |
| `ChatHistoryController` | Provides REST access to archived messages. |
| `MessageRepository` | Handles CRUD operations for the H2 `message` table. |

---

## Getting Started

### Prerequisites
- **JDK 17** or newer
- **Maven 3.9+**

### Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/shubhyagami/chat-In-Terminal.git
   cd chat-In-Terminal
   ```
2. Build the project:
   ```bash
   ./mvnw clean package
   ```

### Running the Application
The project compiles into a single JAR containing both the server and the client logic.

**1. Start the Server:**
```bash
java -jar target/chat-in-terminal-*.jar
```
*The server defaults to port 8080.*

**2. Join a Room:**
```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/42
```
*Replace `42` with your desired room ID. Use `--help` for more options.*

**3. Fetch History:**
You can view the chat history of a room using `curl`:
```bash
curl http://localhost:8080/api/rooms/42/history
```

---

## API Reference

### Get Room History
`GET /api/rooms/{id}/history`

Returns a JSON array of all messages associated with the specified room ID.

**Response Schema:**
| Field | Type | Description |
| :--- | :--- | :--- |
| `timestamp` | String | ISO-8601 UTC timestamp |
| `author` | String | The username of the sender |
| `content` | String | The message body |

---

## Development

To ensure stability, the project maintains 100% test coverage. Run the test suite using:

```bash
./mvnw test
```

The project follows the standard Maven lifecycle. Contributions to the terminal UI or new API endpoints are welcome.

## Contributing

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/your-feature-name`.
3. Commit your changes and ensure all tests pass.
4. Open a Pull Request against the `main` branch.

For more details, please refer to [CONTRIBUTING.md](CONTRIBUTING.md).

## License

Distributed under the MIT License. See [LICENSE](LICENSE) for more information.

## Changelog

| Date | Version/Change |
| :--- | :--- |
| 2026-09-17 | Polished README for clarity and structure. |
| 2026-09-04 | Added status badges and reorganized sections. |
| 2026-09-01 | Refactored WebSocket config and added API documentation. |
| 2026-08-29 | Initial installation guide and basic README setup. |
