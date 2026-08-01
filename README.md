┌─────────────────────────────────────────────────────────────────────────┐
│   ___ _   _    _    ___ _   _ _____ ___  ___   _   _ ___ ____          │
│  / __| | | |  /  \  |_ _| \| |_   _/ _ \|  _ \ | \  | |_ _|  _ \        │
│ | (__| |_| | / _  \ || ||  \| | || | | | |   / |  \  | || || |_) |       │
│  \___|\___/ /_/ \_\___|_|\__| |_| |_| |_|_|_\ |_|\__|___|____/        │
│          Chat in Terminal – Real‑time Java WebSocket Chat              │
└─────────────────────────────────────────────────────────────────────────┘

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)
[![Java](https://img.shields.io/badge/Java-17+-orange?logo=java)](https://openjdk.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)
[![Render](https://img.shields.io/badge/deploy%20on-Render-46E3B7?logo=render)](https://render.com/)
[![Stars](https://img.shields.io/github/stars/shubhyagami/chat-In-Terminal?style=social)](https://github.com/shubhyagami/chat-In-Terminal)
[![Last Commit](https://img.shields.io/github/last-commit/shubhyagami/chat-In-Terminal)](https://github.com/shubhyagami/chat-In-Terminal/commits/main)
[![Issues](https://img.shields.io/github/issues/shubhyagami/chat-In-Terminal)](https://github.com/shubhyagami/chat-In-Terminal/issues)

# Chatinterminal

Simple terminal-style chat web application built with Spring Boot, WebSocket (STOMP) and H2.

## Features
- Create or join rooms via shareable links: `/room/{room}`
- Real-time chat using STOMP over WebSocket (endpoint: `/ws`)
- Messages persisted to H2 (file-based) and history available via REST

## Quick start (Java + Maven)

1. Build:

```powershell
cd "c:\Users\shubh\OneDrive - MSFT\Desktop\Spring Project\chatinterminal"
.\mvnw -DskipTests package
```

2. Run:

```powershell
.\mvnw -DskipTests spring-boot:run
# then

---

## 🕰️ Contributing – TVA Temporal Style

Welcome, Variant! You've been pruned from your timeline and helped us maintain the Sacred Timeline of **Chatinterminal**. All contributions must pass through the Time Variance Authority's strict approval process. Follow these temporal protocols:

### 🔧 Prerequisites
- You must have a **TemPad** (your local Git clone) synced with the Sacred Repository.
- Install the **Minutemen Toolkit** (Java 17+, Maven, and a text editor that respects linear time).
- Know your **Variant ID** (GitHub username) – we’ll log every nexus event.

### 📜 Nexus Event Guidelines
1. **Create a new branch** from the Sacred Timeline (`main`):
   ```bash
   git checkout -b feature/my-nexus-event
   ```
2. **Prune divergent timelines** – ensure your code doesn’t create paradoxes (merge conflicts). Rebase often.
3. **Write time-resistant tests** – every commit must pass `mvn test`. A failing test will trigger a **Reset Charge**.
4. **Document your changes** in

---

## 🧠 Pro Tips

Make the most of **Chatinterminal** with these advanced tricks:

- **Room names as tags**: Use descriptive room names like `project-alpha` or `team-lunch` – the URL becomes your invite link.
- **Persistent history**: All messages are stored in H2. Access past conversations via `GET /api/rooms/{room}/messages`.
- **Multi‑terminal simulation**: Open two browser tabs with the same room URL to test real‑time messaging side‑by‑side.
- **Lightweight deployment**: The app runs on a single JAR – ideal for quick demos or internal team chats without setting up a database server.

---

## 📅 Changelog

### 2026-08-02 – Temporal Patch

- **New feature**: Added `Pro Tips` section to README to help users master the chat experience.
- **Docs**: Enhanced contribution guidelines with clearer temporal metaphors.
- **Stability**: No code changes – this is a pure documentation nexus event.

---

> *“The only constant in real-time chat is change – embrace the flow.”* – TVA Temporal Engineer