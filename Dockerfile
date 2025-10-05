## Multi-stage build for a Spring Boot application
## Build stage: use Maven to build the fat jar
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN mvn -v
COPY src ./src
RUN mvn -DskipTests package -P !native -Dskip.native -DskipITs=true -e -B package

## Run stage: lightweight JRE
FROM eclipse-temurin:17-jre-jammy
VOLUME /tmp
COPY --from=build /workspace/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java","-jar","/app/app.jar"]
