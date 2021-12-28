package com.pradipta.practice.repository;

import com.pradipta.practice.entity.Course;
import com.pradipta.practice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(CourseRepositoryTest.class);

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        logger.info("Courses : {}", courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}