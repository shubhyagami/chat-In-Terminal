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
   All branch names must follow the `feature/` or `fix/` prefix. Unauthorised branches will be erased from history.

2. **Write Sacred Code**  
   - Follow existing code style (we use the **TVA Style Guide** – aka Java conventions + no tab characters allowed, only spaces).
   - Keep commits atomic. A single commit that tries to do everything is a **Nexus Event** and will be pruned.
   - All new features must include tests. Untested code is a paradox waiting to happen.

3. **Submit a Temporal Retrieval Request (PR)**  
   - Describe what your change does, why it is necessary for the Sacred Timeline, and attach a screenshot of the working terminal UI (if applicable).
   - Tag at least one **Minuteman** (maintainer) for review.
   - Do **not** include any debug logs that reveal the location of the TVA (we don’t want Lokis running around).

4. **Wait for Judgement**  
   - A Minuteman will review your code. If it passes, it gets merged into the Prime Timeline.
   - If your PR introduces a timeline branch that threatens the Sacred Timeline, it will be **pruned** without warning (closed and deleted).

### Code of Conduct (TVA Edition)

- **No variants** – all contributors are equal before the Time-Keepers.
- **Respect the Loom** – do not spam, harass, or create unnecessary noise in issues or PRs.
- **No time travel** – do not attempt to commit code from the future (we can tell).

### Need Help?

If you are uncertain about any step, contact the **Time-Keepers** by opening an issue with the `help-wanted` label. A Minuteman will respond within one timeline cycle (usually 48 hours).

**Remember:** The TVA is watching. Make every commit count.  

— *Ouroboros, Temporal Engineer (Senior Grade)*