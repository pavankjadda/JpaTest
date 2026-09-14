# JpaTest — LLM Guidelines

## Project Overview

**JpaTest** is a small Java/Spring Boot sandbox application used to experiment with JPA / Hibernate features against MS
SQL Server running in Docker: entity mappings and relationships, projections, Hibernate event listeners, Envers
auditing, batching, and Spring Data query derivation. It exposes a handful of REST endpoints to exercise those features.

There is no authentication, no multi-tenancy, and no external system integration — keep it that way unless explicitly
asked.

---

## Tech Stack

| Layer       | Technology                                     |
|-------------|------------------------------------------------|
| Language    | Java 25                                        |
| Framework   | Spring Boot 4.x (Web, Data JPA)                |
| Database    | MS SQL Server (Docker) — Hibernate 7           |
| Auditing    | Hibernate Envers via Spring Data Envers        |
| Schema      | Hibernate `ddl-auto: update` (no migrations)   |
| Test data   | Datafaker                                      |
| Boilerplate | Lombok                                         |
| Build       | Maven (wrapper: `./mvnw`)                      |
| Testing     | JUnit 6, REST Assured, Spring Boot test slices |
| CI          | GitHub Actions (`.github/workflows/build.yml`) |

---

## Package Structure

All code lives under `com.pj.jpatest`:

```
config/            Spring @Configuration classes (async executor, Hibernate event listener registration)
web/               REST controllers
service/           Business logic — interface + *Impl
repository/        Spring Data JPA repositories and custom DAOs
domain/            JPA entities
dto/               Data transfer objects and projections (records)
dto/request/       Request payload records
listeners/         Hibernate event listeners (insert/update/delete)
```

Layering: `web → service → repository → domain`.

---

## Build & Run

### Prerequisites

- JDK 25
- Docker
- Maven (or use the bundled `./mvnw`)

### Start MS SQL Server

```shell
docker volume create docker_mssql_volume
```

```shell
docker run --platform linux/amd64 --restart always -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Test#12345" -v docker_mssql_volume:/var/opt/mssql -p 1433:1433 -d --name jpa_test mcr.microsoft.com/mssql/server:2022-latest
```

Create the `jpa_test` database once; Hibernate generates the schema from the entities on startup.

### Build

```shell
./mvnw clean package -DskipTests
```

### Run

```shell
./mvnw spring-boot:run
```

Or from IntelliJ, main class `com.pj.jpatest.JpaTestApplication`.

The application runs at `http://localhost:8081`.

---

## General Guidelines

- **Complete code**: Always produce complete code snippets — include imports, package declarations, and class
  definitions. Never truncate code or SQL queries mid-way.
- **Spring Boot 4.x compatibility**: All generated code must be compatible with Spring Boot 4.x and Hibernate 7.
- **SQL Server compatibility**: All generated queries and mappings must be compatible with MS SQL Server.
- **Follow existing conventions**: Match the structure and style of the surrounding codebase.
- **Deprecated APIs**: Never use deprecated APIs or patterns.
- **Error handling**: Implement proper exception handling and validation at every layer.
- **Logging**: Use structured logging with appropriate log levels (`DEBUG`, `INFO`, `WARN`, `ERROR`).
- **Performance**: Consider performance implications, especially N+1 queries, fetch strategies, and batching.
- **Documentation**: Always document methods and complex logic with Javadoc. Author should always be
  "Pavan Kumar Jadda" if you can't get it from git history. Version should be the next version after the one in
  `pom.xml` — e.g. if `pom.xml` has 1.4.0, new code uses `@since 1.4.1`.
- **Constants**: Do not hard-code strings, numbers, or error messages — use constants instead.
- **AI attribution**: MUST NOT add AI attribution banners, signatures, or similar messages to code, comments, commits,
  pull requests, or any other artifact. That includes lines such as "Generated with Claude Code" and "Made with
  Cursor", and any equivalent wording.

---

## Coding Conventions

### Java

- Use **Java 25+ features**: records, sealed classes, switch expressions, pattern matching, text blocks.
- Use `jakarta.*` packages — **not** `javax.*`.
- Use Java **records** for DTOs, request payloads, and projections.
- Use **Lombok** only where Java 25+ features don't cover it. Never use `@Data`, `@ToString`, or `@EqualsAndHashCode`
  on an entity.
- Use `Long` for all entity primary key IDs.
- Always prefer `var` over explicit types, unless the compiler cannot infer the type.
- Prefer constructor injection over field injection.

### Spring

- Use standard stereotypes: `@Service`, `@Repository`, `@RestController`, `@Component`, `@Configuration`.
- Apply `@Transactional` at the **service layer**.
- Use `Optional<T>` for potentially absent values in service and repository layers.

### REST API

- Prefix all API endpoints with `/api/v1/`.
- Controllers use `@RestController` and `@RequestMapping`, with `@GetMapping` / `@PostMapping` / etc. on methods.
- Validate request bodies with `jakarta.validation.constraints` and `@Valid`.
- Return meaningful HTTP status codes.
- Use records for request/response DTOs — see `dto/request/CreateSportRequest.java`.
- Follow RESTful conventions for endpoint naming and HTTP verbs.

### Persistence

- Use Spring Data JPA repositories (`extends JpaRepository<Entity, Long>`).
- Entities must use `@Entity`, `@Table`, and `@Id`; annotate audited entities with `@Audited`.
- Prefer JPQL or Spring Data query methods over raw/native SQL.
- Use records for database projections — see `dto/BookSummary.java`.
- Hibernate event listeners are registered in `config/HibernateConfig.java`; add new listeners there rather than
  scattering callbacks.
- Schema is generated by Hibernate (`ddl-auto: update`) — there are no migration scripts to write.

---

## Testing

- Framework: **JUnit 6** (`org.junit.jupiter.api`) — not JUnit 4.
- Use `@SpringBootTest` with REST Assured for controller/API tests — see `AuthorControllerTest`.
- Use `@DataJpaTest` with `@AutoConfigureTestDatabase(replace = NONE)` for repository tests so they run against the
  real SQL Server instance — see `BookRepositoryTest`.
- Tests require the SQL Server container to be running.
- Never create unit tests unless explicitly asked.

---

## Configuration

- Single YAML file: `src/main/resources/application.yml`.
- Datasource, JPA, Envers, and Hibernate logging settings all live there.
- Commented-out MySQL / PostgreSQL / DB2 datasource blocks are kept intentionally for switching databases — leave them
  in place.

---

## What to Avoid

- Do not change files or start writing code unless explicitly asked.
- Deprecated Spring or Hibernate APIs.
- `javax.*` — always use `jakarta.*`.
- Raw or native SQL unless JPQL and Spring Data are genuinely insufficient.
- Lombok `@Data`, `@ToString`, `@EqualsAndHashCode` on entities.
- Adding frameworks or infrastructure this project doesn't have (security, migrations, caching, messaging) unless
  explicitly asked.
- Cutting off code snippets or SQL queries — always produce complete, ready-to-use code.
- Never commit to git or create PRs unless explicitly asked; commit as the current user, not as an LLM.
- Never add AI-generated attribution lines anywhere.