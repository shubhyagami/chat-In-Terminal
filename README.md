[K[2m  [2mmodel deepseek-ai/deepseek-v4.1-flash failed, trying next...[0m[0m
[K[2m  [2mmodel openai/gpt-oss-20b failed, trying next...[0m[0m
[K[2m  [2mmodel openai/gpt-oss-120b failed, trying next...[0m[0m
# Chat-In-Terminal

*A lightweight Spring Boot 3.x application that functions as both a WebSocket chat server and a terminal-based client.*

This project is distributed as a single executable JAR. Depending on the arguments provided, it can either host the chat service (Server Mode) or join a specific room via the command line (Client Mode).

---

## Badges

![Build Status](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MIT License](https://img.shields.io/badge/License-MIT-yellow)
![Test Coverage](https://img.shields.io/badge/Tests-100%25-brightgreen)

---

## Key Features

- **Dual-Mode Execution**: A single JAR handles both server-side orchestration and client-side interaction.
- **Room Isolation**: Numeric room IDs ensure conversations remain private and separate.
- **Real-time Messaging**: Utilizes STOMP over WebSockets for low-latency communication.
- **Built-in Persistence**: Messages are stored in an embedded H2 database with automatic timestamps.
- **History API**: Access past conversations via a simple REST endpoint.
- **Zero Dependency Setup**: No external database or message broker installation required.

---

## Quick Start

### 1. Build the Project
```bash
./mvnw clean package
```

### 2. Start the Server
Run the JAR without arguments to start the server on the default port (8080).
```bash
java -jar target/chat-in-terminal-*.jar
```
- **WebSocket Endpoint**: `ws://localhost:8080/ws`
- **REST API**: `http://localhost:8080`

### 3. Join a Room (Client Mode)
Open a new terminal and pass a room URL as an argument to join.
```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
```
- **Sending**: Type your message and press `Enter`.
- **Exiting**: Press `Ctrl+C`.

---

## Technical Architecture

```
Terminal (STOMP) → Spring Boot WebSocket → H2 Database
                                     ↘︎ REST API ↙
```

- **`WebSocketConfig`**: Configures the `/ws` endpoint and the internal message broker.
- **`MessageController`**: Manages STOMP traffic, persists incoming messages, and broadcasts them to the appropriate room.
- **`ChatHistoryController`**: Provides REST access to the message archive.
- **`MessageRepository`**: A Spring Data JPA repository for database operations.

---

## Detailed Usage

### Prerequisites
- **JDK 17+** (OpenJDK or Oracle)
- **Maven 3.9+** (Included via Maven Wrapper)

### Server Configuration
To run the server on a custom port:
```bash
java -jar target/chat-in-terminal-*.jar -Dserver.port=9090
```

### Client Options
The client supports various flags for configuration. To see all available options:
```bash
java -jar target/chat-in-terminal-*.jar --help
```

### Accessing History via API
You can retrieve the conversation history of a specific room using `curl`:
```bash
curl http://localhost:8080/api/rooms/42/history
```

**Response Format:**
```json
[
  {
    "timestamp": "2026-09-17T12:34:56Z",
    "author": "alice",
    "content": "Hello, world!"
  }
]
```

---

## API Reference

### `GET /api/rooms/{id}/history`
Returns a JSON array of all messages associated with the given room ID.

| Field | Type | Description |
| :--- | :--- | :--- |
| `timestamp` | String | ISO-8601 UTC creation time. |
| `author` | String | Username of the sender. |
| `content` | String | The message text. |

---

## Development

### Running Tests
The project maintains 100% test coverage through JUnit and integration tests.
```bash
./mvnw test
```

### Project Structure
```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/        # WebSocket & App configuration
 │   │   ├─ controller/    # REST and STOMP handlers
 │   │   └─ repository/    # Database access layer
 │   └─ resources/        # application.yml and schema
 └─ test/
     └─ java/...          # Unit & integration tests
```

### Contributing
1. Create a feature branch: `git checkout -b feature/your-feature`
2. Implement changes and add corresponding tests.
3. Verify all tests pass: `./mvnw test`
4. Submit a Pull Request to `main`.

For detailed guidelines, please refer to [`CONTRIBUTING.md`](CONTRIBUTING.md).

---

## License
Distributed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Changelog

| Date | Change |
| :--- | :--- |
| 2026-09-24 | Polished README for clarity, improved organization, and fixed phrasing. |
| 2026-09-19 | Refined README structure and added project badges. |
| 2026-09-17 | Updated documentation and introduced code-coverage reporting. |
| 2026-09-04 | Added REST API documentation and expanded architecture section. |
| 2026-09-01 | Optimized WebSocket configuration and expanded test suite. |
| 2026-08-29 | Initial repository creation. |
