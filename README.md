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
```

---

## 🕰️ Contributing – TVA Temporal Code Guidelines

Welcome, Variant! You've been recruited by the Time Variance Authority to help maintain the **Sacred Timeline** of this chat application. Every pull request is a nexus event that must be pruned, approved, or integrated into the flow of time itself.

### 📜 The Temporal Code of Conduct

- **No branch shall fork the Sacred Timeline.** Always work from the `main` branch and create feature branches with meaningful names (e.g., `fix/room-creation`, `feat/typing-indicator`).
- **Do not alter the past.** Never force-push to `main` without an approved review from a Time-Keeper (maintainer).
- **Reset Charges are for bugs, not commits.** Use `git revert` or `git reset` only when absolutely necessary to correct a temporal anomaly.

### 🛠 How to Contribute (Approved by the Time-Keepers)

1. **File a Temporal Variance Report** – Open an issue describing the anomaly (bug) or enhancement you wish to introduce. Label it as `bug`, `feature`, or `documentation`.
2. **Create a Nexus Event** – Fork the repository and clone your variant:
   ```bash
   git clone https://github.com/YOUR_USERNAME/chat-In-Terminal.git
   cd chat-In-Terminal
   git checkout -b fix/your-nexus-event
   ```
3. **Deploy the Minutemen** – Write clean, well-documented code. Run all tests:
   ```bash
   .\mvnw test
   ```
4. **Request a Temporal Approval** – Push your branch and open a pull request. In the description, reference the issue number and explain how your change affects the timeline.
5. **Await the Time-Keeper's Judgement** – A maintainer will review your PR. If it passes, your variant will be merged into the Sacred Timeline. If it creates a paradox, you'll be asked to revise.

### 🔧 What We’re Looking For

- **UI/UX improvements** – Make the terminal look even more retro-futuristic.
- **Room persistence** – Save room names and allow custom usernames.
- **Typing indicators** – Show when a user is composing a message.
- **Emoji support** – Because even the TVA needs to express temporal frustration.
- **Performance optimizations** – Keep the timeline stable under high chat volume.

### ⚡ Quick Commands for TVA Agents

```powershell
# Check if your local timeline is in sync
git pull --rebase

# View recent temporal anomalies (git log)
git log --oneline --graph --all

# Prune merged branches (clean up variants)
git branch --merged | Select-String -NotMatch "main" | ForEach-Object { git branch -d $_.ToString().Trim() }
```

---

Thank you for helping us maintain the Sacred Timeline. Together we ensure that Chatinterminal remains the only chat application that exists – and the only one that *should* exist.

— **The Time-Keepers** (Maintainers of this Repository)