
# Todo practice application

This is the documentation regarding the todo application.

This application has two components.

A simple front end page with basic javascript to use fetch() methods to do the api calls

A simple backend application developed using spring boot


## Technologies Used
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white)](https://www.oracle.com/java/)
[![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?logo=javascript&logoColor=black)](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
[![TailwindCSS](https://img.shields.io/badge/Tailwind_CSS-38B2AC?logo=tailwindcss&logoColor=white)](https://tailwindcss.com/)



## API Reference

#### Get all tasks

```http
  GET /todo
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| / | `List<Task>` | **Required**. Fetches all tasks |

#### Get Task By Id

```http
  GET /todo/${taskId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `taskId`      | `Task` | **Required**. Fetch task by Id |


#### Post new task

```http
  POST /todo
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Task`      | `Task` | **Required**. Post a new task |

#### Update existing task

```http
  PUT /todo/${taskId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Task`,`taskId`    | `Task` | **Required**. Update an existing task |

#### Delete existing task

```http
  DELETE /todo/${taskId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `taskId`    | `void` | **Required**. Delete a task|

## Authors

- [@pandya-manan ](https://github.com/pandya-manan)

