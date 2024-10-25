# Student Management System

A Spring Boot project for managing student data using Spring Data JPA. It includes functionalities for creating, reading, updating, and deleting student records, along with associated guardian information.

## Features

- Add new students with basic details and guardian information.
- Retrieve students by first name or email.
- Update student details such as first name using their email address.
- Delete students by email.
- Test cases to validate CRUD operations using JUnit.

## Technologies Used

- **Spring Boot**: Framework for building Java applications.
- **Spring Data JPA**: For data persistence and repository management.
- **MySQL**: Database to store student information.
- **JUnit 5**: For unit testing the repository methods.
- **Lombok**: To reduce boilerplate code for entities (getters, setters, etc.).

## Project Structure

```bash
src/
 ├── main/
 │   ├── java/shivani/spring_boot_3/    # Main source files
 │   │   ├── Entity/                    # Entity classes (StudentEntity, Gaurdian)
 │   │   ├── Repository/                # Spring Data JPA repository interfaces
 │   └── resources/                     # Application properties, SQL scripts
 ├── test/                              # Test classes for unit testing
 └── pom.xml                            # Maven dependencies
```

## Database Schema

This project uses MySQL with the following schema:

- **student_table**: Stores student details including name, email, and guardian information.
  - `std_id`: Auto-generated ID.
  - `first_name`: Student's first name.
  - `last_name`: Student's last name.
  - `email_address`: Unique email address.
  - `guardian`: Embedded object with guardian details.

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/shivani-7024/Unit_Testing/tree/master
   ```

2. **Configure MySQL:**
   - Create a database named `student_db`.
   - Update `src/main/resources/application.properties` with your MySQL credentials.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_db
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

4. **Run the project:**
   ```bash
   mvn spring-boot:run
   ```

5. **Test the API using Postman or any REST client**:
   - Add a new student: `POST /api/students`
   - Get all students: `GET /api/students`
   - Update student: `PUT /api/students/{email}`
   - Delete student: `DELETE /api/students/{email}`

## Testing

Unit tests are available to validate repository functionality:

- **Run tests using Maven:**
   ```bash
   mvn test
   ```

The test class `Student_repositoryTest` includes test cases for saving, retrieving, updating, and deleting student records.

## Example Usage

- **Add a Student with Guardian:**
   ```java
   Gaurdian guardian = Gaurdian.builder()
       .name("John Doe")
       .email("john.doe@gmail.com")
       .mobile("1234567890")
       .build();

   StudentEntity student = StudentEntity.builder()
       .firstName("Aman")
       .last_name("Gupta")
       .email("aman@gmail.com")
       .gaurdian(guardian)
       .build();
   student_repository.save(student);
   ```

- **Find a Student by Email:**
   ```java
   StudentEntity student = student_repository.findstudentByEmailAddressNative("aman@gmail.com");
   ```

- **Update a Student's Name:**
   ```java
   student_repository.updateStudentEntityByEmail("Aman Kumar", "aman@gmail.com");
   ```


This `README.md` provides all essential information about your Spring Boot project, including features, setup, and how to run and test the application.
