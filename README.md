┌─────────────────────────────────────────────────────────────────────────┐
│   ___ _   _    _    ___ _   _ _____ ___  ___   _   _ ___ ____          │
│  / __| | | |  /  \  |_ _| \| |_   _/ _ \|  _ \ | \  | |_ _|  _ \        │
│ | (__| |_| | / _  \ || ||  | | || | | | |   / |  \  | || || |_) |       │
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
# then open http://localhost:8080
```

---

## 🚀 Pro Tips – TVA Edition

### 1. **Room Naming – Avoid Paradoxes**
   Use short, descriptive room names (e.g., `nexus-42`). Long names may cause **temporal drift** (URL encoding issues). Stick to alphanumeric and hyphens.

### 2. **WebSocket – Keep Your TemPad Synced**
   If messages stop flowing, your WebSocket connection may have been **pruned**. Reload the page – the STOMP client automatically reconnects.

### 3. **H2 Console – The Archives of Time**
   Access the in‑memory database at `/h2-console` (JDBC URL: `jdbc:h2:file:./data/chatdb`). Use it to inspect past nexus events (messages). But beware: editing records could create **branched timelines** – for authorized Minutemen only.

### 4. **Deploy on Render – No Temporal Reset Needed**
   The project is ready for Render. Set environment variable `SPRING_PROFILES_ACTIVE=render` and ensure `PORT` is set. Your chat room will survive even a **multiverse collapse**.

### 5. **Browser Console – Your TemPad Log**
   Open DevTools to see STOMP frames. Look for `CONNECTED` and `SUBSCRIBED` – if you see `ERROR`, check your broker configuration.

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
4. **Document your changes** in the pull request – every PR is a **temporal report**.
5. **Stay aligned** – all code must follow the style of the Sacred Timeline. Use the same indentation, naming conventions, and commit message format.

---

## 📅 Changelog – Nexus Event 2026‑08‑03

### Added
- **Pro Tips section** – Because even Minutemen need a little temporal guidance.
- **Changelog entry** – First official nexus event record. All future updates will be logged here.
- **Temporal Quote** – A motivational message for those who guard the Sacred Timeline.

### Changed
- Minor improvements to ASCII banner alignment (multiverse‑proof).
- Updated `README.md` structure for better flow across all timelines.

### Fixed
- No bugs were pruned – the timeline remains intact.

---

## 💬 Temporal Quote

> *“Time is a flat circle. But chat messages are linear – so keep them flowing.”*  
> — Anonymous TVA Analyst, Year 3048

---

*Maintained by the Time Variance Authority – Approved for all timelines.*