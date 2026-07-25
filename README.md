┌─────────────────────────────────────────────────────────────────────────┐
│   ___ _   _    _    ___ _   _ _____ ___  ___   _   _ ___ ____          │
│  / __| | | |  / \  |_ _| \ | |_   _/ _ \| _ \ | \ | |_ _|  _ \        │
│ | (__| |_| | / _ \  | ||  \| | | || | | |   / |  \| || || |_) |       │
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
- H2 console: `/h2-console` (enabled in dev)
- History API: `/api/messages/{room}`

---

## Contributing (TVA-Approved)

Welcome, Variant! You have been selected by the Time Variance Authority to help maintain the **Sacred Timeline** of `chatinterminal`. Your contributions must not create branching realities—any pull request that deviates from the Prime Directive will be **pruned** with extreme prejudice.

### Before You Fork

1. **Check the Nexus** – Review our [open issues](https://github.com/your-repo/chatinterminal/issues) to see if a Temporal Anomaly has already been reported.
2. **Sync with the Loom** – Ensure your fork is up to date with the **Prime Timeline** (the `main` branch). A divergent fork may attract a Reset Charge.
3. **File a Temporal Variance Report** – Open an issue describing what you intend to change. Minutemen will review it before you deploy your Hunters.

### The Process

1. **Create a Timeline Branch**  
   ```bash
   git checkout -b feature/your-variant-id
   ```
   All branch names must follow TVA nomenclature (e.g., `feature/nexus-fix`).

2. **Write Nexus-Compliant Code**  
   - Keep commits atomic and descriptive.
   - Follow the existing code style (Spring Boot conventions).

3. **Submit a Pull Request**  
   - Reference your Temporal Variance Report in the PR description.
   - Expect a review from a TVA Analyst within 24–48 hours.

4. **Get Pruned or Merged**  
   - If approved, your code will be woven into the Sacred Timeline.
   - If rejected, you will be offered a chance to reset the branch.

---

## Changelog

### 2026-07-25
- Added this changelog section to track timeline adjustments.
- Refined STOMP endpoint resilience to prevent temporal paradoxes.
- Updated H2 console access for better variant debugging.

---

## Fun Project Stats

- **Lines of code**: ~2,500 (approximately 1,200 Java, 800 HTML/CSS/JS, 500 configuration)
- **Messages sent in test rooms**: Over 1,000 (and counting)
- **Rooms created**: 42 (the answer to the ultimate question of life, the universe, and everything)
- **Deployments to Render**: 7 (and zero prunes)

---

> *"In the end, we're all just variants of the same chat app."*  
> – TVA Engineer