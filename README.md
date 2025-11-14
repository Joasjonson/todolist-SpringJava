

To-Do List API — Spring Boot

REST API for task management, built with Spring Boot, Spring Data JPA, H2 Database, Swagger, and custom global exception handling.

Features

- Create tasks
- List all tasks
- Search for tasks by ID
- Search for tasks by status (Pending, InProgress, Completed)
- Update a task
- Delete a task
- Global error handling
- Documentation via Swagger  ("http://localhost:8080/swagger-ui/index.html")

Technologies Used

- Java 17+
- Spring Boot 3+
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Swagger 
- Custom Exceptions
- Global exception handling with @RestControllerAdvice

```
git clone https://github.com/Joasjonson/todolist-SpringJava.git
cd todolist-SpringJava

mvn clean install
mvn spring-boot:run

Test the endpoints.

# GET http://localhost:8080/tasks

#POST http://localhost:8080/tasks
Body (JSON):
{
    "title": "Nova Tarefa",
    "description": "Aprendendo Spring Boot",
    "status": "PENDING"
}

#GET http://localhost:8080/tasks/{id}

#PUT http://localhost:8080/tasks/{id}
Body (JSON):
{
    "title": "Tarefa Atualizada",
    "description": "Nova descrição",
    "status": "DONE"
}

DELETE http://localhost:8080/tasks/{id}
GET http://localhost:8080/tasks/status/PENDING


```
