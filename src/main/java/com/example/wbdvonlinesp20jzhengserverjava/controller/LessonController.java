package com.example.wbdvonlinesp20jzhengserverjava.controller;

import com.example.wbdvonlinesp20jzhengserverjava.models.Lesson;
import com.example.wbdvonlinesp20jzhengserverjava.models.Topic;
import com.example.wbdvonlinesp20jzhengserverjava.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LessonController {

    @Autowired
    LessonService lessonService;

    @PostMapping("/api/modules/{moduleId}/lessons")
    public Lesson createLesson(@PathVariable("moduleId") Integer mid, @RequestBody Lesson lesson) {
        return lessonService.createLesson(mid, lesson);
    }

    @GetMapping("/api/modules/{moduleId}/lessons")
    public List<Lesson> findLessonsForModule(@PathVariable("moduleId") Integer mid) {
        return lessonService.findLessonsForModule(mid);
    }

    @PutMapping("/api/lessons/{lessonId}")
    public int updateLesson(@PathVariable("lessonId") Integer lid,
                           @RequestBody Lesson lesson) {
        return lessonService.updateLesson(lid, lesson);
    }

    @DeleteMapping("/api/lessons/{lessonId}")
    public int deleteLesson(@PathVariable("lessonId") Integer lid) {
        return lessonService.deleteLesson(lid);
    }

    @GetMapping("/api/lessons")
    public List<Lesson> findAllLessons() {
        return lessonService.findAllLessons();
    }

    @GetMapping("/api/lessons/{lessonId}")
    public Lesson findLessonById (@PathVariable("lessonId") Integer lid) {
        return lessonService.findLessonById(lid);
    }
}
