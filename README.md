# Task Tracker

Простое приложение на **Java**, **Spring Boot** и **PostgreSQL** для управления задачами (CRUD).

---

## Технологии

- Java 25
- Spring Boot 4.0.2
- Maven
- PostgreSQL 16
- Docker / Docker Compose

---

## Описание

Приложение позволяет:

- Создавать задачи с заголовком, описанием и статусом
- Получать список всех задач
- Обновлять задачи (заголовок, описание, статус)
- Удалять задачи

Задачи могут иметь статус:

- `NEW` – новая задача
- `IN_PROGRESS` – задача в процессе
- `DONE` – задача выполнена

---

## API

Базовый URL: `/tasks`

| Метод | URL | Описание | Тело запроса |
|-------|-----|----------|--------------|
| GET   | `/tasks` | Получить список всех задач | - |
| POST  | `/tasks` | Создать новую задачу | `TaskCreateRequest` |
| PATCH | `/tasks/{id}` | Обновить задачу по ID | `TaskUpdateRequest` |
| DELETE| `/tasks/{id}` | Удалить задачу по ID | - |

### Примеры DTO

**TaskCreateRequest**

```json
{
  "title": "Новая задача",
  "description": "Описание задачи",
  "status": "NEW"
}
```

**TaskUpdateRequest**

```json
{
  "title": "Обновлённая задача",
  "description": "Новое описание",
  "status": "IN_PROGRESS"
}
```

**SuccessResponse**

```json
{
  "message": "Task was deleted successfully.",
  "status": 200
}
```

**TaskResponse**

```json
{
  "id": 1,
  "title": "Новая задача",
  "description": "Описание задачи",
  "status": "NEW"
}
```

## База данных

**Используется PostgreSQL. Таблица task создаётся через миграцию:**

```
create table task (
    id bigserial primary key,
    title varchar(256) not null,
    description varchar(256),
    status varchar(256)
);
```

## Конфигурация

**application.yaml:**

```
spring:
  profiles:
    active: dev
  datasource:
    url: jdbc:postgresql://localhost:5432/tasks
    username: tasks
    password: tasks
  jpa:
    hibernate:
      ddl-auto: none
    show-sql: true
```

## Исключения

**Если задача с указанным ID не найдена, возвращается:**

```json
{
  "timestamp": "2026-02-12T15:00:00",
  "status": 404,
  "error": "Task not found with id = 1",
  "path": "/tasks/1"
}
```

## Структура проекта
```
src/
├─ main/
│   ├─ java/com/example/tacktracker/
│   │   ├─ controller/      # REST контроллеры
│   │   ├─ service/         # Логика приложения
│   │   ├─ repository/      # Репозитории для БД
│   │   ├─ entity/          # Сущности
│   │   ├─ dto/             # DTO для запросов и ответов
│   │   ├─ enums/           # Enum для статусов задач
│   │   └─ exception/       # Обработка ошибок
│   └─ resources/
│       ├─ db/migration/    # SQL миграции
│       └─ application.yaml # Конфигурация
├─ docker-compose.yml
├─ pom.xml
└─ Dockerfile
```