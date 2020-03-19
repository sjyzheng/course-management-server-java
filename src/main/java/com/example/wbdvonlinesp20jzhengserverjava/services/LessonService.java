package com.example.wbdvonlinesp20jzhengserverjava.services;

import com.example.wbdvonlinesp20jzhengserverjava.models.Lesson;
import com.example.wbdvonlinesp20jzhengserverjava.models.Module;
import com.example.wbdvonlinesp20jzhengserverjava.repositories.LessonRepository;
import com.example.wbdvonlinesp20jzhengserverjava.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    ModuleRepository moduleRepository;

    public Lesson createLesson(Integer mid, Lesson newLesson) {
        Module module = moduleRepository.findById(mid).get();
        newLesson.setModule(module);
        return lessonRepository.save(newLesson);
    }

    public List<Lesson> findLessonsForModule(Integer mid) {
        return lessonRepository.findLessonsForModule(mid);
    }

    public int updateLesson(Integer lid, Lesson updatedLesson) {
        Lesson lessonToUpdate = lessonRepository.findLessonById(lid);
        lessonToUpdate.setTitle(updatedLesson.getTitle());

        lessonRepository.save(lessonToUpdate);
        return 1;
    }

    public int deleteLesson(Integer lid) {
        lessonRepository.deleteById(lid);
        return 1;
    }

    public List<Lesson> findAllLessons() {
        return (List<Lesson>) lessonRepository.findAll();
    }

    public Lesson findLessonById(Integer lid) {
        return lessonRepository.findLessonById(lid);
    }
}
