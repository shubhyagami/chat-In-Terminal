Deploying this Spring Boot app to Render using Docker

1) Build locally (optional)

   docker build -t chatinterminal:latest .

2) Run locally

   docker run -p 8080:8080 chatinterminal:latest

3) Deploy on Render

   - Create a new Web Service on Render and choose "Docker" as the environment.
   - Connect your repository and set the build command to the default (Render will run docker build).
   - Expose port 8080 (Render automatically maps the container port; ensure your service's health checks point to /).
   - Environment variables: if you want to use a file-backed H2 database you can leave defaults; for production use a managed database and update `spring.datasource.url` accordingly.

Notes
   - The Dockerfile uses a Maven multi-stage build so Render will build the jar during image build.
   - For production, replace H2 with Postgres/MySQL and update application.properties and JDBC URL.
