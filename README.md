# Chat In Terminal

A lightweight, terminal‑based chat application that lets you create or join isolated chat rooms via shareable URLs. It uses Spring Boot, STOMP over WebSocket, and an H2 database for persistent chat history.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=java)](https://openjdk.org/)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)
[![H2 Database](https://img.shields.io/badge/Database-H2-0064ab?logo=h2)](https://www.h2database.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/shubhyagami/chat-In-Terminal?style=social)](https://github.com/shubhyagami/chat-In-Terminal)

## Features
- **Isolated rooms** – each URL maps to its own independent chat room.  
- **Real‑time messaging** – messages are delivered instantly via STOMP/WebSocket.  
- **Persistent history** – every message is stored in an H2 database and can be retrieved through a REST API.  
- **Upcoming enhancements** – avatar persistence, role‑based moderation, and file sharing.

## Changelog (2026‑08‑29)
- Polished the README and added concise installation instructions.  
- Updated badges to reflect the latest Spring Boot and Java versions.  

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
3. Open `http://localhost:8080` in a browser to access the chat interface.  

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
