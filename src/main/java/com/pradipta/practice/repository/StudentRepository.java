package com.pradipta.practice.repository;

import com.pradipta.practice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);
    public List<Student> findByLastNameNotNull();

    /**
     * JPQL Query Example - Based on the entity defined
     * @param emailId emailId
     * @return Student
     */
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddress(String emailId);

    /**
     * Native Query Example - Based on the database table
     * @param emailId emailId
     * @return Student
     */
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", nativeQuery = true)
    public Student getStudentByEmailAddressNative(String emailId);

    /**
     * Native Query Example - Based on the database table - Named Param
     * @param emailId emailId
     * @return Student
     */
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId", nativeQuery = true)
    public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
}
