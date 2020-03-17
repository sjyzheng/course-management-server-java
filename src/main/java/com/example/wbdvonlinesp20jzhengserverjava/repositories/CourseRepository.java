package com.example.wbdvonlinesp20jzhengserverjava.repositories;

import com.example.wbdvonlinesp20jzhengserverjava.models.Course;
import com.example.wbdvonlinesp20jzhengserverjava.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Query("SELECT course FROM Course course")
    public List<Course> findAllCourses();

    @Query("SELECT course FROM Course course WHERE course.id=:cid")
    public Course findCourseById(@Param("cid") Integer courseId);
}
