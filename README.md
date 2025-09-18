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