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
# then o
---

## 🚀 Temporal Roadmap

> *The TVA Temporal Engineer has reviewed the Sacred Timeline. To prevent terminal chat multiversal collapse, the following upgrades are planned across the timeplanes. Pruning delays may occur.*

- [ ] **Temporal Multi-Verse (v0.2.0)** — Implement persistent user avatars across sessions so identities remain stable when timelines branch.
- [ ] **Minuteman Moderation (v0.3.0)** — Room roles and moderation commands (`/prune`, `/reset`, `/silence`) to maintain the Sacred Timeline of each room.
- [ ] **Miss Minutes AI (v0.4.0)** — Automated welcome messages, FAQ hints, and temporal reminders delivered when users join a room.
- [ ] **Time Door File Sharing (v0.5.0)** — Upload and share files through the terminal interface without uploading them to the Void.
- [ ] **Chronomarker Emotes (v0.6.0)** — A curated emoji and reaction system themed around temporal consensus and timeline ping.
- [ ] **TVA Analytics Console (v0.7.0)** — Optional metrics dashboard to monitor room activity, latency, and nexus event frequency.
- [ ] **Alioth Resistance (v1.0.0)** — Full stress-tested release hardened for unexpected temporal surges and chaotic branching traffic.

> *All timeline projections are estimated and may shift if Miss Minutes decides to interfere.*
---

### Temporal Update

Auto-maintained entry for 2026-08-06 23:58 (chat-In-Terminal).

---

### Temporal Update

Auto-maintained entry for 2026-08-06 23:59 (chat-In-Terminal).

---

### Temporal Update

Auto-maintained entry for 2026-08-07 00:02 (chat-In-Terminal).
