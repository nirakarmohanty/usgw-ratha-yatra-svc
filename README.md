# Rathayatra Service

Small Spring Boot service (Maven) to manage admins. This `README.md` shows how to configure the database (`application.yaml`), how to run the service and a sample request body for the admin endpoint.

## Prerequisites
\- Java 17\+  
\- Maven 3.6\+  
\- PostgreSQL (local or Docker)  
\- Docker (optional, recommended for quick Postgres setup)

## Configuration
Update `src/main/resources/application.yaml` (or your environment) with the datasource settings. Example:

    spring:
      datasource:
        url: jdbc:postgresql://localhost:5432/rathayatra_db
        username: rathayatra_user
        password: ChangeMe123!
        driver-class-name: org.postgresql.Driver
      jpa:
        hibernate:
          ddl-auto: update    # options: none, validate, update, create, create-drop
        show-sql: true

`spring.jpa.hibernate.ddl-auto: update` will auto-create missing tables/columns (safe for development).

## PostgreSQL credentials (example)
Use these credentials for local development or when running the provided Docker container:

\- Host: `localhost`  
\- Port: `5432`  
\- Database: `rathayatra_db`  
\- Username: `rathayatra_user`  
\- Password: `ChangeMe123!`

## Run Postgres via Docker (recommended)
Run this command (Docker Desktop on Windows):

    docker run --name rathayatra-postgres \
      -e POSTGRES_DB=rathayatra_db \
      -e POSTGRES_USER=rathayatra_user \
      -e POSTGRES_PASSWORD=ChangeMe123! \
      -p 5432:5432 -d postgres:15

Wait a few seconds for Postgres to initialize, then start the Spring Boot app.

## Build & Run
From project root (where `pom.xml` is located):

    mvn clean package
    mvn spring-boot:run

Or run the generated jar:

    java -jar target/<artifact>-<version>.jar

## Example Admin API
Sample JSON request body for creating an admin (`AdminRequest`):

    {
      "name": "Jane Doe",
      "email": "jane.doe@example.com"
    }

Example curl (adjust endpoint path if different):

    curl -X POST http://localhost:8080/api/admins \
      -H "Content-Type: application/json" \
      -d '{"name":"Jane Doe","email":"jane.doe@example.com"}'

## Notes
\- Check `pom.xml` for Spring Boot and PostgreSQL JDBC driver dependencies.  
\- For production, set credentials via environment variables or a secrets manager and avoid `ddl-auto: create`/`update`.  
\- For schema control in production, use migrations (Flyway or Liquibase).
