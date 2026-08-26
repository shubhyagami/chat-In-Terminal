# Chat In Terminal

A real-time, terminal-based chat web application that enables users to create and join isolated chat rooms using shareable links. Built with Spring Boot, STOMP over WebSocket, and an H2 database, this application allows users to communicate instantly.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17+-orange?logo=java)](https://openjdk.org/)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)
[![H2 Database](https://img.shields.io/badge/Database-H2-0064ab?logo=h2)](https://www.h2database.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/shubhyagami/chat-In-Terminal?style=social)](https://github.com/shubhyagami/chat-In-Terminal)

## Features

- **Isolated Rooms**: Create and easily share unique chat rooms using URLs.
- **Real-time Messaging**: Instant message delivery using STOMP over WebSocket.
- **Persistent Chat History**: Store and retrieve chat logs in an H2 database via a REST API.

## Getting Started

This application is built with Java 17 and above. To get started:

1. Clone the repository using `git clone https://github.com/shubhyagami/chat-In-Terminal.git`
2. Navigate into the cloned repository `cd chat-In-Terminal`
3. Build and run the application using `./mvnw spring-boot:run`
4. The application will be available at `http://localhost:8080`

## Key Features and Future Developments

- **Persistent User Avatars**: Enhance user experience by retaining user identities and avatars across sessions.
- **Moderation and Management**: Introduce roles and moderation commands for improved room management.
- **File Sharing and Customization**: Allow users to upload and share files directly through the terminal interface.

## Changelog

A brief overview of the project's major updates:

### [0.1.0] - 2026-08-07
- Initial release with core real-time chat functionality
- Room isolation and H2 database persistence for chat history established

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
