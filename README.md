# Chat In Terminal

A lightweight, real‑time chat application that runs in a terminal and lets users create or join isolated chat rooms via shareable URLs. The app is built with Spring Boot, STOMP over WebSocket, and an H2 database for persistent chat history.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=java)](https://openjdk.org/)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)
[![H2 Database](https://img.shields.io/badge/Database-H2-0064ab?logo=h2)](https://www.h2database.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/shubhyagami/chat-In-Terminal?style=social)](https://github.com/shubhyagami/chat-In-Terminal)

## Features
- **Isolated Rooms**: Create and share unique chat rooms through URLs.
- **Real‑time Messaging**: Instant message delivery using STOMP over WebSocket.
- **Persistent History**: Store and retrieve chat logs in an H2 database via a REST API.
- **Future Enhancements**: Avatar persistence, role‑based moderation, and file sharing.

## Prerequisites
- Java 17 or later
- Maven (or the provided `./mvnw` wrapper)

## Getting Started
1. Clone the repository  
   ```bash
   git clone https://github.com/shubhyagami/chat-In-Terminal.git
   cd chat-In-Terminal
   ```
2. Build and run the application  
   ```bash
   ./mvnw spring-boot:run
   ```
3. Open a terminal and navigate to `http://localhost:8080` to access the chat interface.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
