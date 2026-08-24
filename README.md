# Chat In Terminal

A real-time, terminal-based chat web application built with Spring Boot, STOMP over WebSocket, and an H2 database. Users can create and join isolated chat rooms using shareable links and communicate instantly.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17+-orange?logo=java)](https://openjdk.org/)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)
[![H2 Database](https://img.shields.io/badge/Database-H2-0064ab?logo=h2)](https://www.h2database.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/shubhyagami/chat-In-Terminal?style=social)](https://github.com/shubhyagami/chat-In-Terminal)

## Features

- **Isolated Rooms:** Create and join unique chat rooms using shareable URLs.
- **Real-time Messaging:** Instant message delivery using STOMP over WebSocket.
- **Persistent Chat History:** Chat logs are stored in an H2 database and can be retrieved via a REST API.

## Getting Started

### System Requirements

- Java 17 or higher

### Installation and Running

1. Clone the repository:

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
```

2. Build and run the application:

```bash
./mvnw spring-boot:run
```

The application will be available at `http://localhost:8080`.

## Future Developments

- **Persistent User Avatars:** Retain user identities and avatars across sessions.
- **Moderation and Management:** Introduce roles and moderation commands for improved room management.
- **File Sharing and Customization:** Allow file uploads and sharing directly through the terminal interface.

## Changelog

### [0.1.0] - 2026-08-07
- Established core real-time chat functionality.
- Implemented room isolation and H2 database persistence for chat history.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
