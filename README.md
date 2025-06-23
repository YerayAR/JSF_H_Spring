# Location Map Application

This project demonstrates a small full stack Java application.  The UI is built with **JSF** so no templating substitutions are used.  A **Spring Boot** backend exposes REST endpoints and uses **Hibernate** for persistence in a **PostgreSQL** database.  Locations can be viewed on a Google Map.

## Requirements

- Docker and Docker Compose
- Maven (for manual build)

## Quick Start

Build and start the containers:

```bash
docker-compose up --build
```

The application will be available at `http://localhost:8080/index.xhtml`.

## Testing the Components

1. **Compile**

   Build the WAR locally using Maven:

   ```bash
   mvn -q package -DskipTests
   ```

   The resulting `target/demo-0.0.1-SNAPSHOT.war` can be run with:

   ```bash
   java -jar target/demo-0.0.1-SNAPSHOT.war
   ```

2. **Verify the REST API**

   After the application is running, query all locations:

   ```bash
   curl http://localhost:8080/api/locations
   ```

3. **Test Database Access**

   You can connect to the PostgreSQL container:

   ```bash
   docker exec -it <compose_db_container> psql -U $DB_USER -d locationdb
   ```

   Ensure the `locations` table contains the default data from `data.sql`.

4. **Check the JSF UI**

   Open `http://localhost:8080/index.xhtml` in your browser and confirm the Google Map renders with the markers from the REST API.

## Docker Setup

The project includes a `Dockerfile` for building the Spring Boot application and a
`docker-compose.yml` that starts the Java container together with PostgreSQL.

```bash
docker-compose up --build
```

The first build may take a while as Maven downloads dependencies. Database data
is stored in the `db_data` volume so it persists across restarts.

## Environment Variables

- `DB_USER` – database username (`locuser` by default)
- `DB_PASS` – database password (`locpass` by default)

These can be defined in a `.env` file or exported in the shell before running `docker-compose`.

## Troubleshooting

- Ensure ports `8080` and `5432` are free before starting Docker Compose.
- If dependencies fail to download during the first build, retry `docker-compose up --build` once the connection stabilizes.
- Check container logs with `docker-compose logs web` or `docker-compose logs db` if the application does not start correctly.

## Default Data

A single location is inserted via `data.sql` when the application starts. Update `index.xhtml` to add your Google Maps API key.
The default marker sits at coordinates `0, 0`. Add more entries through the REST API or by editing `data.sql`.
