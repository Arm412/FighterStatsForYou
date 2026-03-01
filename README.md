# FighterStatsForYou — Monorepo scaffold

This repository contains a monorepo scaffold with an Angular frontend and two backends: Java Spring Boot and Python Django.

Layout
- `frontend/` — Angular app (use Angular CLI inside this folder)
- `backend/`
  - `java/` — Spring Boot app (Maven)
  - `python/` — Django app
- `docs/` — project documentation
- `scripts/` — helper scripts

Quick starts

**Java (Spring Boot) Backend**

Option 1: Run with Docker Compose (recommended)
```powershell
docker compose up --build
```
This starts both the PostgreSQL database and the Spring Boot app. The app will be available on `http://localhost:8080`. Use `docker compose up -d --build` to run in the background, and `docker compose down` to stop.

Option 2: Run locally with Maven
First, ensure PostgreSQL is running in Docker:
```powershell
docker compose up -d postgres
```
This starts only the PostgreSQL container. The database data is persisted in Docker's named volume `pgdata`, which survives container restarts. Then, run the Spring Boot app locally:
```powershell
.\scripts\run-maven-docker.ps1 -Args 'spring-boot:run' -Module 'backend/java'
```
The app will connect to the database at `localhost:5432` and be available on `http://localhost:8080`.

**Python (Django) Backend**
- Create a virtualenv, `pip install -r requirements.txt`, then `python manage.py runserver` in `backend/python`

This is a scaffold; follow README files in subfolders for details.

Security note: environment variables and local credentials

This repo uses docker-compose to run a local Postgres database. Credentials are configured via environment variables and should not be committed to source control.

The datasource URL in `backend/java/src/main/resources/application.properties` is templated to use the `POSTGRES_HOST` environment variable, which defaults to `localhost` for local development and is overridden to `postgres` when running in Docker containers.

Environment Configuration
- Default credentials: username `fs_user`, password `fs_password`, database `fighterstats_db`
- Override with environment variables: `POSTGRES_HOST`, `POSTGRES_PORT`, `POSTGRES_DB`, `POSTGRES_USER`, `POSTGRES_PASSWORD`
- Example override:
  ```bash
  POSTGRES_HOST=myhost POSTGRES_PORT=5433 docker compose up --build
  ```

Do not commit credentials to source control. It is included in `.gitignore`.