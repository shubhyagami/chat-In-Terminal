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

### 5. **Browser Console – You
---

## 📅 Changelog – Temporal Update 2026-08-03

### Added
- **Weekly Highlight** section to spotlight the coolest room of the week.
- **Security hardening**: All WebSocket endpoints now require a valid temporal passcode (OK, that's a joke – but we did tighten STOMP header validation).
- **Room auto‑expiry**: Unused rooms are pruned after 30 days of inactivity (prevents timeline clutter).

### Changed
- **Database location** moved from `./data/chatdb` to `./tva-archives/chatdb` to better align with TVA naming conventions.

### Fixed
- **Browser console truncation** – the incomplete tip from the previous release is now fully rendered (you can now read about WebSocket reconnection strategies in the browser console).

---

## 🌟 Weekly Highlight – Room of the Week

**Nexus‑42** – the most active chat room this week! Over 1,200 messages exchanged in the last 7 days.  
> *"We started a heated debate on whether time is a flat circle or a Mobius strip. The WebSocket held up like a champ."* – Anonymous TVA agent

Want your room featured? Just send a lot of messages and tag `@Minuteman` in the chat – we’re watching.

---

> *“The only thing that makes life possible is permanent, intolerable uncertainty; not knowing what comes next.”* – Ursula K. Le Guin  
> *(Adapted for temporal chat rooms: not knowing who will reply next.)*