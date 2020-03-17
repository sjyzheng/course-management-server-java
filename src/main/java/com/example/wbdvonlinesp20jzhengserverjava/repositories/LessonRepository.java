package com.example.wbdvonlinesp20jzhengserverjava.repositories;

import com.example.wbdvonlinesp20jzhengserverjava.models.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {

    @Query("SELECT lesson FROM Lesson lesson")
    public List<Lesson> findAllLessons();

    @Query("SELECT lesson FROM Lesson lesson WHERE lesson.module.id=:mid")
    public List<Lesson> findLessonsForModule(@Param("mid") Integer moduleId);

    @Query("SELECT lesson FROM Lesson lesson WHERE lesson.id=:lid")
    public Lesson findLessonById(@Param("lid") Integer lessonId);
}
