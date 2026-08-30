# Chat‑In‑Terminal

A lightweight, terminal‑based chat application that lets you create or join isolated chat rooms via shareable URLs. Built with Spring Boot, STOMP over WebSocket, and an H2 database for persistent chat history.

---  

## Badges  

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)  
[![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=java)](https://openjdk.org/)  
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)  
[![Database](https://img.shields.io/badge/Database-H2-0064ab?logo=h2)](https://www.h2database.com/)  
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

---  

## Features  

- **Isolated rooms** – each URL maps to its own independent chat room.  
- **Real‑time messaging** – messages are delivered instantly via STOMP over WebSocket.  
- **Persistent history** – every message is stored in an H2 database and can be accessed through a REST API.  
- **Upcoming enhancements** – avatar persistence, role‑based moderation, file sharing.  

---  

## Changelog (2026‑08‑29)  

- Refined the README with clearer wording.  
- Added concise installation instructions.  
- Updated badges to reflect the latest Spring Boot and Java versions.  

---  

## Prerequisites  

- Java 17 or later  
- Maven (or use the provided `./mvnw` wrapper)  

---  

## Getting Started  

1. Clone the repository  
   git clone https://github.com/shubhyagami/chat-In-Terminal.git  
   cd chat-In-Terminal  

2. Build and run  
   ./mvnw spring-boot:run  

3. Open the chat interface  
   Navigate to http://localhost:8080 in your browser  

---  

## License  

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
