package com.interview_preparation_portal.service.impl;

import com.interview_preparation_portal.entity.Topic;
import com.interview_preparation_portal.repository.TopicRepository;
import com.interview_preparation_portal.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }
}