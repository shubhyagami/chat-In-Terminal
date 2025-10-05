# Chatinterminal

Simple terminal-style chat web application built with Spring Boot, WebSocket (STOMP) and H2.

Features
- Create or join rooms via shareable links: /room/{room}
- Real-time chat using STOMP over WebSocket (endpoint: /ws)
- Messages persisted to H2 (file-based) and history available via REST

Quick start (Java + Maven)

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

Docker (optional)
- A multi-stage `Dockerfile` is included. Build and run locally:

```powershell
docker build -t chatinterminal:latest .
docker run -p 8080:8080 chatinterminal:latest
```

Render deployment
- See `README-RENDER.md` for notes about deploying the provided Dockerfile to Render.

Useful endpoints
- Web UI: /
- Room page: /room/{room}
- H2 console: /h2-console (enabled in dev)
- History API: GET /api/history/{room}
- Rooms list: GET /api/rooms

Notes
- The application uses an H2 file database in development (jdbc:h2:file:./data/chatdb). For production replace with a managed DB and update `application.properties`.
- If you see malformed rows with room value `[[${room}]]`, they were created before Thymeleaf binding was fixed — consider cleaning them via the H2 console.
