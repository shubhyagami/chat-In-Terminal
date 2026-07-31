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

Welcome, Variant! You've been pruned from your timeline and recruited to help us maintain the Sacred Timeline of **Chatinterminal**. All contributions must pass through the Time Variance Authority's strict approval process. Follow these temporal protocols:

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
4. **Document your changes** in the PR description. Explain how they preserve the Sacred Timeline (or why a minor deviation is acceptable).

### 🔍 Time-Keeper Code Review
- A **TVA Analyst** (maintainer) will review your PR. Expect questions like:
  > “Does this change prevent a Kree invasion of the WebSocket handshake?”
- All reviews are final – no time loops allowed.

### 🚀 Pruning a Bug (Reporting Issues)
Found a timeline anomaly? File an **Incident Report** (GitHub Issue) with:
- **Variant ID** (your GitHub username)
- **Timeline coordinates** (steps to reproduce)
- **Expected vs. actual behavior** (what the Sacred Timeline says vs. what you observed)
- **Logs or screenshots** (we'll run a temporal scan)

### 🏆 Rewards for Loyal Minutemen
- Merged PRs earn you a **TVA Badge** (your name in the `CONTRIBUTORS.md` file).
- First-time contributors receive a **Time Stick** (virtual high-five from the team).
- Repetitive Nexus Events (spam, trolls) will be **reset to zero** (banned).

### 🧪 Code of Conduct
All variants must abide by the **TVA Code of Conduct**: be kind, stay in your timeline, and never try to escape the Void (no malicious code).

---

*“All timelines lead to a better Chatinterminal. Do your duty, Variant.”*

― The Time-Keepers