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
```

---

## 🕰️ TVA-Approved Contributing Guidelines

**Greetings, Variant!**  
You have been selected by the Time Variance Authority to contribute to the **Sacred Timeline** of `chat-In-Terminal`. Your mission, should you choose to accept it, is to help maintain the flow of real-time conversation across all branching realities. Failure to comply may result in **pruning** (or at least a code review).

### 🔍 How to File a Nexus Event (Issue)

1. **Check the timeline first** – Search existing issues to avoid creating a paradox.
2. **Use a clear, descriptive title** – No temporal duplicates, please.
3. **Tag your issue** with one of these TVA classifications:
   - `Bug: Variant Behavior` – Something is out of sync.
   - `Feature: New Branch` – A new ability that doesn't break the timeline.
   - `Enhancement: Chronal Optimization` – Make the code run faster than the speed of time.

### 🛠️ Submitting a Prune Request (Pull Request)

1. **Fork the repository** – every timeline deserves a copy
2. **Create a branch** named after your timeline (e.g., `fix/message-order-paradox`)
3. **Write tests** – the TVA demands certainty across all realities
4. **Open a PR** with a clear description of the timeline change

---

## 🧠 Pro Tips for Time-Traveling Chatters

- **Room Naming**: Use unique names to avoid temporal collisions. `/room/thor-racoon` is safer than `/room/room1`.
- **Message History**: All messages are stored in H2 – you can review past conversations via REST at `/api/messages/{room}`.
- **STOMP Debug**: Enable client-side logging with `stomp.debug = true` in browser console – perfect for debugging cross‑universe lag.
- **Deploy on Render**: One‑click deploy with the badge above – your chat will persist across all branching timelines.
- **Prune Old Rooms**: To reset a room’s history, simply delete the `data/` folder (H2 file) and restart – the timeline will be rewritten.

---

## 📅 Changelog – 2026‑07‑31

- Added TVA‑themed contributing guidelines and pro tips.
- Improved WebSocket stability across multiple parallel universes.
- H2 database now prunes automatically every 24 hours (configurable via `app.history.retention-hours`).

---

*This project is part of the Sacred Timeline. Any deviation will be corrected by the Time Keepers.*