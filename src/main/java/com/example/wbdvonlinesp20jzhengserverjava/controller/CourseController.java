package com.example.wbdvonlinesp20jzhengserverjava.controller;

import com.example.wbdvonlinesp20jzhengserverjava.models.Course;
import com.example.wbdvonlinesp20jzhengserverjava.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/api/courses/{courseId}")
    public int updateCourse(@PathVariable("courseId") Integer cid,
                           @RequestBody Course course) {
        return courseService.updateCourse(cid, course);
    }

    @DeleteMapping("/api/courses/{courseId}")
    public int deleteCourse(@PathVariable("courseId") Integer cid) {
        return courseService.deleteCourse(cid);
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/api/courses/{courseId}")
    public Course findCourseById (@PathVariable("courseId") Integer cid) {
        return courseService.findCourseById(cid);
    }
}
