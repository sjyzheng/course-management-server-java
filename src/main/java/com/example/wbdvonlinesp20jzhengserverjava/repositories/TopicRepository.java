package com.example.wbdvonlinesp20jzhengserverjava.repositories;

import com.example.wbdvonlinesp20jzhengserverjava.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    @Query("SELECT topic FROM Topic topic")
    public List<Topic> findAllTopics();

    @Query("SELECT topic FROM Topic topic WHERE topic.lesson.id=:lid")
    public List<Topic> findTopicsForLesson(@Param("lid") Integer lessonId);

    @Query("SELECT topic FROM Topic topic WHERE topic.id=:tid")
    public Topic findTopicById(@Param("tid") Integer topicId);
}
