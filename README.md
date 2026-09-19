[K[2m  [2mmodel openai/gpt-oss-20b failed, trying next...[0m[0m
[K[2m  [2mmodel openai/gpt-oss-120b failed, trying next...[0m[0m
# Chat-In-Terminal

Chat-In-Terminal is a lightweight command-line chat client and server powered by Spring Boot 3.x. It leverages STOMP over WebSockets for real-time communication and uses an embedded H2 database to persist chat history, which can be accessed via a REST API.

![Build Status](https://github.com/shubhyagami/chat-In-Terminal/actions/workflows/maven.yml/badge.svg)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot 3.x](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MIT](https://img.shields.io/badge/License-MIT-yellow)
![Test Coverage](https://img.shields.io/badge/Tests-100%25-brightgreen)

## Quick Start

```bash
# 1. Build the project
./mvnw clean package

# 2. Start the server
java -jar target/chat-in-terminal-*.jar
# Server runs at http://localhost:8080 (REST) and ws://localhost:8080/ws (WebSocket)

# 3. Connect the terminal client to a room (in a new terminal tab)
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/1
# Replace '1' with any room ID. Use --help for available flags.
```

The client reads from `stdin`. Simply type your message and press **Enter** to send.

## Features

- **Room Isolation**: Independent chat rooms identified by unique IDs.
- **Real-time Messaging**: Low-latency delivery via STOMP over WebSockets.
- **Persistent History**: Messages are stored with timestamps in an H2 database.
- **History API**: Retrieve past room conversations via a simple REST endpoint.
- **Unified Distribution**: Single JAR file handles both server and client roles.

## Architecture

`Client (Terminal) → STOMP WebSocket → Spring Boot → H2 Database`

### Component Breakdown

| Component | Responsibility |
|-----------|----------------|
| `WebSocketConfig` | Configures the `/ws` endpoint and message broker. |
| `MessageController` | Processes inbound messages and broadcasts them to the broker. |
| `ChatHistoryController` | Exposes the REST API for room history retrieval. |
| `MessageRepository` | Handles database persistence for the `message` table. |

## Getting Started

### Prerequisites

- JDK 17 or newer
- Maven 3.9+

### Installation

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
./mvnw clean package
```

### Running the Server

Start the server using the generated JAR:
```bash
java -jar target/chat-in-terminal-*.jar
```
The server defaults to port `8080`. To change the port, use: `-Dserver.port=9090`.

### Joining a Room

Connect using the client mode by passing the room URL:
```bash
java -jar target/chat-in-terminal-*.jar http://localhost:8080/rooms/42
```
The client will automatically connect to room `42`, display current active messages, and wait for user input.

### Fetching History via CLI

You can retrieve the JSON history of a room using `curl`:
```bash
curl http://localhost:8080/api/rooms/42/history
```

## API Reference

### GET `/api/rooms/{id}/history`

Returns a JSON array of all messages associated with the specified room ID.

**Response Example:**
```json
[
  {
    "timestamp": "2026-09-17T12:34:56Z",
    "author": "alice",
    "content": "Hello, world!"
  }
]
```

**Field Definitions:**
- `timestamp`: ISO-8601 UTC string.
- `author`: The username of the sender.
- `content`: The message body.

## Development

### Testing
Run the full test suite with Maven:
```bash
./mvnw test
```
The project maintains 100% test coverage to ensure stability across updates.

### Project Structure
```
src/
 ├─ main/
 │   ├─ java/com/example/chat/
 │   │   ├─ config/        # WebSocket & App configuration
 │   │   ├─ controller/     # REST and STOMP handlers
 │   │   └─ repository/     # Database access layer
 │   └─ resources/        # application.yml
 └─ test/                 # JUnit and Integration tests
```

## Contributing

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/your-feature`.
3. Ensure all tests pass: `./mvnw test`.
4. Submit a Pull Request to the `main` branch.

For detailed guidelines, please refer to `CONTRIBUTING.md`.

## License

This project is distributed under the MIT License. See [LICENSE](LICENSE) for more information.

## Changelog

| Date | Change |
|------|--------|
| 2026-09-19 | Refined README for better clarity and organization. |
| 2026-09-17 | Polished documentation and added project badges. |
| 2026-09-04 | Added API documentation and expanded architecture details. |
| 2026-09-01 | Updated WebSocket configuration and added coverage tracking. |
| 2026-08-29 | Initial repository creation. |
