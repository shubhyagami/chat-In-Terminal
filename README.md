┌─────────────────────────────────────────────────────────────────────────┐
│   ___ _   _    _    ___ _   _ _____ ___  ___   _   _ ___ ____          │
│  / __| | | |  /  \  |_ _| \| |_   _/ _ \|  _ \ | \  | |_ _|  _ \        │
│ | (__| |_| | / _  \ | ||  \| | || | | | |   / |  \  | || || |_) |       │
│  \___|\___/ /_/ \_\___|_|\__| |_| |_| |_|_|_\ |_|\__|___|____/        │
│          Chat in Terminal – Real‑time Java WebSocket Chat              │
└─────────────────────────────────────────────────────────────────────────┘

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue?logo=socket.io)](https://stomp.github.io/)
[![Java](https://img.shields.io/badge/Java-17+-orange?logo=java)](https://openjdk.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)
[![Render](https://img.shields.io/badge/deploy%20on-Render-46E3B7?logo=render)](https://render.com/)

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

## Docker (optional)
- A multi-stage `Dockerfile` is included. Build and run locally:

```powershell
docker build -t chatinterminal:latest .
docker run -p 8080:8080 chatinterminal:latest
```

## Render deployment
- See `README-RENDER.md` for notes about deploying the provided Dockerfile to Render.

## Useful endpoints
- Web UI: `/`
- Room page: `/room/{room}`
- H2 console: `/h2-console` (enabled)

---

## 📜 Sacred Timeline Roadmap

As the TVA Temporal Engineer, I have drafted the following branched timelines for this project. Our current timeline is stable, but these enhancements will prevent future multiversal fragmentation (and make the app a lot cooler).

### ⏳ Temporal Enhancements
- [ ] **Chronal Disguises (UI Themes):** Implement alternate terminal themes (Amber, Retro Green-Screen,Matrix) so variants feel at home in their own timeline.
- [ ] **Pruning Mechanism (Message Reactions):** Allow users to "prune" messages with emoji reactions, keeping the timeline clean.
- [ ] **Nexus Event Alerts (Typing Indicators):** Broadcast temporal disruptions—meaning "User is typing..." indicators across the Whisper-Socket network before a nexus event occurs.

### 🌀 Multiversal Architectural Upgrades
- [ ] **Time-Keeper Database Migration:** Upgrade from H2 to PostgreSQL for larger persistent chronologies (Goliath-scale memory).
- [ ] **Standardized Mutant Cycles (CI/CD):** Integr

## 🧭 Pro Tips for Temporal Agents

- **Room shortcuts:** Append `/room/your-room-name` to any browser URL to instantly create or join a room. Perfect for temporal task forces.
- **Persistence is key:** All messages survive server restarts thanks to file-based H2. Your timeline never truly resets.
- **STOMP deep dive:** Use a WebSocket client like `wscat` to connect to `/ws` directly and inspect the raw temporal data flow.
- **Docker for variant testing:** Spin up multiple container instances on different ports to simulate inter‑branch communication.

## 📅 Temporal Changelog – 2026-07-27

- **Added** `Pro Tips for Temporal Agents` section to help agents navigate the chat streams.
- **Added** this changelog entry – because even the TVA records its own history.
- **Enhanced** README with creative embellishments while maintaining temporal integrity.

> *“Time is not a straight line; it’s a messy, branching WebSocket connection. Keep your messages persistent.”*  
> — Anonymous TVA Engineer