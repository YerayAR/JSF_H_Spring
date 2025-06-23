# Location Map Application

This project demonstrates a simple JSF front end and Spring Boot REST backend for storing geographic locations and visualizing them on Google Maps.

## Requirements

- Docker and Docker Compose
- Maven (for manual build)

## Quick Start

Build and start the containers:

```bash
docker-compose up --build
```

The application will be available at `http://localhost:8080/index.xhtml`.

## Environment Variables

- `DB_USER` – database username (`locuser` by default)
- `DB_PASS` – database password (`locpass` by default)

These can be defined in a `.env` file or exported in the shell before running `docker-compose`.

## Troubleshooting

- Ensure ports `8080` and `5432` are free.
- If dependencies fail to download, check your internet connection.

## Default Data

A single location is inserted via `data.sql` when the application starts. Update `index.xhtml` to add your Google Maps API key.
