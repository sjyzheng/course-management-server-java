package com.example.wbdvonlinesp20jzhengserverjava.services;

import com.example.wbdvonlinesp20jzhengserverjava.models.Course;
import com.example.wbdvonlinesp20jzhengserverjava.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course createCourse(Course newCourse) {
        return courseRepository.save(newCourse);
    }

    public int updateCourse(Integer cid, Course updatedCourse) {
        Course courseToUpdate = courseRepository.findCourseById(cid);
        courseToUpdate.setTitle(updatedCourse.getTitle());
        courseToUpdate.setDateModified(updatedCourse.getDateModified());

        courseRepository.save(courseToUpdate);
        return 1;
    }

    public int deleteCourse(Integer cid) {
        courseRepository.deleteById(cid);
        return 1;
    }

    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course findCourseById(Integer cid) {
        return courseRepository.findCourseById(cid);
    }
}
