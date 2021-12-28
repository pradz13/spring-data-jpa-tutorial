package com.pradipta.practice.repository;

import com.pradipta.practice.entity.Guardian;
import com.pradipta.practice.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(StudentRepositoryTest.class);

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("pradipta.nag2@gmail.com")
                .firstName("Pradipta")
                .lastName("Nag")
                //.guardianName("Pallab Kumar Nag")
                //.guardianEmail("pallbnag1958@gmail.com")
                //.guardianMobile("123456789")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Keya")
                .email("aa@gmail.com")
                .mobile("124446666")
                .build();

        Student student = Student.builder()
                .emailId("anjay.nag2@gmail.com")
                .firstName("Ajay")
                .lastName("Atul")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        logger.info("Student List : {}", studentList);
    }

    @Test
    public void printStudentExample() {
        List<Student> studentList = studentRepository.findByFirstName("Pradipta");
        logger.info("Student List with passed first name : {}", studentList);

        List<Student> studentListWithContaining = studentRepository.findByFirstNameContaining("Prad");
        logger.info("Student List with passed first name containing : {}", studentListWithContaining);

        List<Student> studentListWithNotNullLastName = studentRepository.findByLastNameNotNull();
        logger.info("Student List with not null last names : {}", studentListWithNotNullLastName);

        Student studentByEmail = studentRepository.getStudentByEmailAddress("pradipta.nag2@gmail.com");
        logger.info("Student by Email : {}", studentByEmail);

        Student studentByEmailNative = studentRepository.getStudentByEmailAddressNative("pradipta.nag2@gmail.com");
        logger.info("Student by Email Native : {}", studentByEmailNative);

        Student studentByEmailAddressNativeNamedParam = studentRepository.getStudentByEmailAddressNativeNamedParam("pradipta.nag2@gmail.com");
        logger.info("Student by Email Native Named Param : {}", studentByEmailAddressNativeNamedParam);
    }

    @Test
    public void updateStudentExample() {
        int updateStudentNameByEmailId = studentRepository.updateStudentNameByEmailId("Pallab", "anjay.nag2@gmail.com");
        logger.info("Update Student Status : {}", updateStudentNameByEmailId);
    }
}