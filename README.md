# Chat In Terminal

A terminal-style chat web application built with Spring Boot, WebSocket (STOMP), and an H2 database. It enables users to create or join isolated chat rooms via shareable links and communicate in real-time.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)
[![Java](https://img.shields.io/badge/Java-17+-orange?logo=java)](https://openjdk.org/)
[![H2 Database](https://img.shields.io/badge/Database-H2-0064ab?logo=h2)](https://www.h2database.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)
[![Render](https://img.shields.io/badge/deploy%20on-Render-46E3B7?logo=render)](https://render.com/)
[![GitHub stars](https://img.shields.io/github/stars/shubhyagami/chat-In-Terminal?style=social)](https://github.com/shubhyagami/chat-In-Terminal)

## Features

- **Room-based Chat:** Create or join isolated chat rooms via shareable links (`/room/{room}`).
- **Real-time Messaging:** Instant message delivery using STOMP over WebSocket (endpoint: `/ws`).
- **Message Persistence:** Chat history is saved to a file-based H2 database and can be retrieved via a REST API.

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven** (The project includes a Maven wrapper, `mvnw`, so a local installation is optional)

### Installation and Running

1. Clone the repository:

```bash
git clone https://github.com/shubhyagami/chat-In-Terminal.git
cd chat-In-Terminal
```

2. Build the project:

```bash
./mvnw -DskipTests package
```

3. Run the application:

```bash
./mvnw -DskipTests spring-boot:run
```

Once running, the application will be available at `http://localhost:8080`.

## Roadmap

- **Persistent User Avatars:** Retain user identities and avatars across sessions.
- **Room Moderation:** Introduce roles and moderation commands (`/kick`, `/mute`, `/clear`).
- **Automated Welcome Bots:** Provide helpful onboarding messages and FAQ hints when users join a room.
- **File Sharing:** Allow file uploads and sharing directly through the terminal interface.
- **Custom Emotes:** Implement an emoji and reaction system tailored for the terminal aesthetic.
- **Analytics Dashboard:** Add a metrics panel to monitor room activity and latency.
- **Performance Hardening:** Stress-test and optimize the system for high-traffic concurrent connections.

## Changelog

### [0.1.0] - 2026-08-07
- Established core real-time chat functionality using Spring Boot and STOMP.
- Implemented room isolation via shareable URLs.
- Added H2 database persistence for chat history.
- Initial README documentation and setup instructions.
