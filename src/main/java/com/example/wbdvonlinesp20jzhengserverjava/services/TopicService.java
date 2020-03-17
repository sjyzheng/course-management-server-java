package com.example.wbdvonlinesp20jzhengserverjava.services;

import com.example.wbdvonlinesp20jzhengserverjava.models.Lesson;
import com.example.wbdvonlinesp20jzhengserverjava.models.Topic;
import com.example.wbdvonlinesp20jzhengserverjava.repositories.LessonRepository;
import com.example.wbdvonlinesp20jzhengserverjava.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    LessonRepository lessonRepository;

    public Topic createTopic(Integer lid, Topic newTopic) {
        Lesson lesson = lessonRepository.findById(lid).get();
        newTopic.setLesson(lesson);
        return topicRepository.save(newTopic);
    }

    public List<Topic> findTopicsForLesson(Integer lid) {
        return topicRepository.findTopicsForLesson(lid);
    }

    public int updateTopic(Integer tid, Topic updatedTopic) {
        Topic topicToUpdate = topicRepository.findTopicById(tid);
        topicToUpdate.setTitle(updatedTopic.getTitle());
        topicToUpdate.setDescription(updatedTopic.getDescription());

        topicRepository.save(topicToUpdate);
        return 1;
    }

    public int deleteTopic(Integer tid) {
        topicRepository.deleteById(tid);
        return 1;
    }

    public List<Topic> findAllTopics() {
        return (List<Topic>) topicRepository.findAll();
    }

    public Topic findTopicById(Integer tid) {
        return topicRepository.findTopicById(tid);
    }

}
