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
- Java: run `mvn spring-boot:run` in `backend/java`
- Python: create a virtualenv, `pip install -r requirements.txt`, then `python manage.py runserver` in `backend/python`
- Frontend: use Angular CLI to create or run the app inside `frontend`

This is a scaffold; follow README files in subfolders for details.

Security note: environment variables and local credentials

This repo uses docker-compose to run a local Postgres database. Credentials are configured via environment variables and should not be committed to source control.

Instructions
1. Copy `.env.example` to `.env` and update values as needed:

   cp .env.example .env

   # On PowerShell (Windows)
   Copy-Item .env.example .env

2. Start Postgres:

   docker-compose up -d postgres

3. The defaults in `.env.example` will match the Spring Boot config in `backend/java/src/main/resources/application.properties`.

Do not commit your `.env` file. It is included in `.gitignore`.