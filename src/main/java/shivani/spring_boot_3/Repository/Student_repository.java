package shivani.spring_boot_3.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shivani.spring_boot_3.Entity.StudentEntity;

import java.util.List;

@Repository
public interface Student_repository extends JpaRepository<StudentEntity, Long> {

    public List<StudentEntity> findByfirstName(String first_name);
    public List<StudentEntity> findByFirstNameContaining(String first_name);

    @Query("select s from StudentEntity s where s.email=?1")
    public List<StudentEntity> findByEmail(String email);

    @Query("select s.firstName from StudentEntity s where s.email=?1")
    public String findByFirstNameByEmail(String email);

    @Query(
            value = "select * from student_table s where s.email_address = ?1",
            nativeQuery = true
    )
    public StudentEntity findstudentByEmailAddressNative(String email);

    @Query(
            value = "select * from student_table s where s.email_address = :email",
            nativeQuery = true
    )
    public StudentEntity findstudentByEmailAddressNativeByNamedParam(String email);

    @Modifying
    @Transactional
    @Query(
            value = "update student_table set first_name = ?1 where email_address= ?2",
            nativeQuery = true
    )
    public int updateStudentEntityByEmail(String first_name, String email);

    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM student_table WHERE email_address = ?1",
            nativeQuery = true
    )
    public int deleteStudentEntityByEmail(String email);

}
