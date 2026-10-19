# Java Student Management System

A beginner-friendly console application demonstrating object-oriented programming and CRUD operations.

## Features
- Add a student
- View all students
- Search by ID
- Update name, department, or CGPA
- Delete by ID
- Basic input validation and friendly error messages
- Prevent duplicate student IDs

## Requirements
- JDK 8 or newer

## Compile and run
Open a terminal in this folder and run:

```bash
javac Main.java Student.java StudentService.java
java Main
```

## Concepts demonstrated
- Classes and objects
- Constructors
- Encapsulation (private fields, getters, setters)
- `ArrayList`
- CRUD
- Loops and `switch`
- Exception handling with `try/catch`
- `Iterator` for safe deletion

Note: This console version stores students in memory. Data is lost when the program exits. A future version could add file or database storage.
