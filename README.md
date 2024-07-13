# Student Data Entry REST API - Demo-1

This project provides a REST API for managing student data entries. The API allows for creating, reading, updating, and deleting student information.

## Table of Contents
- [Introduction](#introduction)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Service Code](#service-code)
- [Spring Configuration](#spring-configuration)
- [Contact](#contact)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project is a Spring Boot application that provides a REST API for managing student data entries. It uses a MySQL database for data storage and includes endpoints for CRUD operations on student data.

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Praveenkolamuri/demo-1.git
    cd demo-1
    ```

2. Ensure you have JDK 8 or higher installed.

3. Create a `application.properties` file in `src/main/resources/` with the following content:
    ```properties
    spring.application.name=demo-1
    server.port=8083
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/demo-1
    spring.datasource.username=root
    spring.datasource.password=Praveen#1221
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    ```

4. Build the project using Maven:
    ```sh
    mvn clean install
    ```

5. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## Usage

Once the application is running, you can access the API at `http://localhost:8083`.

## API Endpoints

### Get All Students
- **URL:** `/students`
- **Method:** `GET`
- **Description:** Retrieve a list of all students.
- **Response:**
    ```json
    [
        {
            "id": 1,
            "name": "John Doe",
            "age": 20,
            "grade": "A"
        },
        ...
    ]
    ```

### Get Student by ID
- **URL:** `/students/{id}`
- **Method:** `GET`
- **Description:** Retrieve a student by their ID.
- **Response:**
    ```json
    {
        "id": 1,
        "name": "John Doe",
        "age": 20,
        "grade": "A"
    }
    ```

### Create Student
- **URL:** `/students`
- **Method:** `POST`
- **Description:** Create a new student.
- **Request Body:**
    ```json
    {
        "name": "Jane Smith",
        "age": 22,
        "grade": "B"
    }
    ```
- **Response:**
    ```json
    {
        "id": 2,
        "name": "Jane Smith",
        "age": 22,
        "grade": "B"
    }
    ```

### Update Student
- **URL:** `/students/{id}`
- **Method:** `PUT`
- **Description:** Update an existing student.
- **Request Body:**
    ```json
    {
        "name": "Jane Smith",
        "age": 23,
        "grade": "A"
    }
    ```
- **Response:**
    ```json
    {
        "id": 2,
        "name": "Jane Smith",
        "age": 23,
        "grade": "A"
    }
    ```

### Delete Student
- **URL:** `/students/{id}`
- **Method:** `DELETE`
- **Description:** Delete a student by their ID.

## Service Code

```java
package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modals.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repo;

    public Employee insert(Employee e) {
        return repo.save(e);
    }

    public Iterable<Employee> addData(List<Employee> employees) {
        return repo.saveAll(employees);
    }

    public List<Employee> getAll() {
        return (List<Employee>) repo.findAll();
    }

    public Optional<Employee> getById(int id) {
        return repo.findById(id);
    }

    public Employee getByEmail(String email) {
        return repo.findByEmail(email);
    }

    public String deleteById(int id) {
        repo.deleteById(id);
        return "Successfully deleted " + id;
    }

    public Employee updateById(Employee e) {
        int id = e.getId();
        Employee emp = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        emp.setRollno(e.getRollno());
        emp.setName(e.getName());
        emp.setBranch(e.getBranch());
        emp.setEmail(e.getEmail());
        emp.setPassword(e.getPassword());
        return repo.save(emp);
    }
}
```

## Spring Configuration

Include the following properties in your `application.properties`:

```properties
spring.application.name=demo-1
server.port=8083
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/demo-1
spring.datasource.username=root
spring.datasource.password=Praveen#1221
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Contact

- LinkedIn: [Sai Praveen Kolamuri](https://www.linkedin.com/in/sai-praveen-kolamuri-7b449822a/)
- GitHub: [Praveenkolamuri](https://github.com/Praveenkolamuri)
- Instagram: [pra_veen2112](https://www.instagram.com/pra_veen2112?igsh=eXZpZnpvcHEzODB3)

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
```
