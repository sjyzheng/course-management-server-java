package com.example.wbdvonlinesp20jzhengserverjava.controller;

import com.example.wbdvonlinesp20jzhengserverjava.models.Topic;
import com.example.wbdvonlinesp20jzhengserverjava.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TopicController {

    @Autowired
    TopicService topicService;

    @PostMapping("/api/lessons/{lessonId}/topics")
    public Topic createTopic(@PathVariable("lessonId") String lid, @RequestBody Topic topic) {
        return topicService.createTopic(lid, topic);
    }

    @GetMapping("/api/lessons/{lessonId}/topics")
    public List<Topic> findTopicsForLessons(@PathVariable("lessonId") String lid) {
        return topicService.findTopicsForLesson(lid);
    }

    @PutMapping("api/topics/{topicId}")
    public int updateTopic(@PathVariable("topicId") Integer tid,
                           @RequestBody Topic topic) {
        return topicService.updateTopic(tid, topic);
    }

    @DeleteMapping("/api/topics/{topicId}")
    public int deleteTopic(@PathVariable("topicId") Integer tid) {
        return topicService.deleteTopic(tid);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }

    @GetMapping("/api/topics/{topicId}")
    public Topic findTopicById (@PathVariable("topicId") Integer tid) {
        return topicService.findTopicById(tid);
    }
}
