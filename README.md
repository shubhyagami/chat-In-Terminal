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
- H2 console: `/h2-console` (ena

---

## 🕰️ TVA Contributing Guidelines

Greetings, variant developer! Welcome to the **Time Variance Authority** of open-source contributions. Every pull request is a nexus event that must be pruned or approved by the Time-Keepers (that’s us, the maintainers). Before you start rewriting the timeline, please read the following sacred decrees.

### ⚖️ The Sacred Timeline Rules

1. **Fork the Timeline** – Create a fork of this repository on your own branch of the Sacred Timeline. Never commit directly to the main branch; that would cause a catastrophic temporal paradox.

2. **Submit a Pruning Request (Pull Request)** – Open a pull request with a clear description of your temporal adjustment. Use the template provided in `.github/PULL_REQUEST_TEMPLATE.md` (or write your own, as long as it’s understandable to a Time-Keeper).

3. **Pass the Temporal Audit** – Your code will be reviewed by the Time-Keepers. We check for:
   - No broken timelines (unit tests pass)
   - No unauthorized time-travel (regressions)
   - Code that follows the **Loki Standard** (clean, readable, and well-documented)
   - Proper use of `@Deprecated` annotations if you’re retiring a feature (like a variant that’s about to be pruned).

4. **No Alioth Unleashed** – Do not introduce any catastrophic bugs that would trigger a full timeline reset. In practice, this means: no breaking changes to the WebSocket or REST API without discussion first.

5. **Keep the TVA Logo Clean** – Stick to the existing code style (Java 17+ with Spring Boot conventions). If you need to introduce new dependencies, create an issue first – we don’t want to overload the Temporal Loom.

### 🧑‍💻 How to Contribute

1. **Report a Temporal Anomaly** – Found a bug? Open an issue with the `bug` label. Describe the timeline branch (OS, Java version, etc.) and include steps to reproduce the paradox.

2. **Request a New Timeline Branch** – Want a new feature? Open an issue with the `enhancement` label. Time-Keepers will decide if it aligns with the project’s destiny.

3. **Submit a Variant Code** – When you’re ready, create a pull request. Use the following commit message format:
   ```
   [TVA-XXXX] Brief description of the timeline adjustment
   ```
   (We don’t actually have issue IDs, but it looks official.)

4. **Sign the TVA Oath** – By contributing, you agree that your code may be pruned, reset, or kept in the archives at the discretion of the Time-Keepers. You also agree that your contributions are MIT-licensed.

### 🛡️ Code of Conduct (TVA Edition)

- Be respectful to all variants, even those from different branches (different programming languages, frameworks, or opinions).
- No harassment, trolling, or intentional timeline sabotage.
- Remember: The TVA exists to preserve the Sacred Timeline. If you disagree with a decision, you may file a formal complaint with the Time-Keepers (but we’re the judges, so good luck).

### 📜 Temporal Loom Build Instructions

To build the project locally and test your changes before submitting:

```powershell
.\mvnw clean compile
```

Run the tests (the Temporal Loom will check for timeline consistency):

```powershell
.\mvnw test
```

If all tests pass, your timeline is stable. Then you can run the application:

```powershell
.\mvnw spring-boot:run
```

### ✨ Final Words

Remember: For all time. Always.

**– The Time-Keepers**