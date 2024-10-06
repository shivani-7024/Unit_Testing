package shivani.spring_boot_3.Repository;

import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shivani.spring_boot_3.Entity.Gaurdian;
import shivani.spring_boot_3.Entity.StudentEntity;

import java.util.List;

@SpringBootTest
class Student_repositoryTest {
    @Autowired
    private Student_repository student_repository;

    @Test
    public void saveStudent(){
        StudentEntity studentEntity = StudentEntity.builder()
                .email("abc@gmail.com")
                .firstName("Aman")
                .last_name("Gupta")
//                .guardian("Papa")
//                .guardian_email("papa@gmail.com")
//                .guardian_phone("1234567890")
                .build();

        student_repository.save(studentEntity);
    }
    @Test
    public void printAllStudents(){
        List<StudentEntity> students = student_repository.findAll();
        System.out.println(students);
    }
    @Test
    public void SaveStudent_WithGuardian(){

        Gaurdian gaurdian = Gaurdian.builder()
                .name("Pita ji ")
                .email("xyz@gmail.com")
                .mobile("7894651245132")
                .build();

        StudentEntity studentEntity = StudentEntity.builder()
                .firstName("rani")
                .email("rani@gmail.com")
                .last_name("kumar")
                .gaurdian(gaurdian)
                .build();
        student_repository.save(studentEntity);
    }

    @Test
    public void printAllStudents_FirstName(){
        List<StudentEntity> student = student_repository.findByfirstName("ra");
        System.out.println(student);
    }

    @Test
    public void printAllStudents_firstName_containing(){
        List<StudentEntity> student = student_repository.findByFirstNameContaining("ra");
        System.out.println(student);
    }

    @Test
    public void printAllStudentsEmail(){
        List<StudentEntity> student = student_repository.findByEmail("ravi@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printFirstNameEmail(){
       String student = student_repository.findByFirstNameByEmail("ravi@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printstudentNavive(){
        StudentEntity studentEntities = student_repository.findstudentByEmailAddressNative("ravi@gmail.com");
        System.out.println(studentEntities);
    }

    @Test
    public void printstudentNaviveNamedParam(){
        StudentEntity studentEntity = student_repository.findstudentByEmailAddressNativeByNamedParam("ravi@gmail.com");
    }

    @Test
    public void udateName(){
        student_repository.updateStudentEntityByEmail("ravi singh", "ravi@gmail.com");
    }

    @Test
    public void deleteStudentByEmail() {
        student_repository.deleteStudentEntityByEmail("ravi@gmail.com");
    }

}