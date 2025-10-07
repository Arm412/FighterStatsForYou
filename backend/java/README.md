# Java Spring Boot backend

This service uses Spring Boot + Spring Data JPA with PostgreSQL.

Local dev quickstart

Options to build/run the service:

1) If you have Maven & Java installed locally (recommended):

   cd backend\java
   mvn spring-boot:run

2) If you don't have Maven installed, use the provided PowerShell helper which runs Maven inside Docker (requires Docker Desktop):

   # from repo root (PowerShell)
   .\scripts\run-maven-docker.ps1 -Args 'spring-boot:run' -Module 'backend/java'

   # or to package
   .\scripts\run-maven-docker.ps1 -Args 'package' -Module 'backend/java'

3) You can also use the Maven Docker image directly:

   # Ensure docker-compose postgres is running first
   docker-compose up -d postgres
   docker run --rm -v ${PWD}:/workspace -w /workspace/backend/java maven:3.9.4-eclipse-temurin-17 mvn spring-boot:run

Start Postgres + app together (recommended for integration)

1. Copy `.env.example` to `.env` and edit values if needed (this is ignored by git):

   Copy-Item .env.example .env

2. Start both services:

   docker-compose up -d

3. Check app logs (optional):

   docker-compose logs -f app

Endpoints

   - Health ping: GET http://localhost:8080/api/ping
   - Fighters list: GET http://localhost:8080/api/fighters
   - Create fighter (POST): POST http://localhost:8080/api/fighters with JSON body {"name":"Jon Doe","weightClass":"Welterweight"}

Notes
- Database connection configured in `src/main/resources/application.properties` and is driven by environment variables.
- JPA is configured with `spring.jpa.hibernate.ddl-auto=update` for convenience in dev.
