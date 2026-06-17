package com.interview_preparation_portal.service;


import com.interview_preparation_portal.entity.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getAllTopics();

    Topic saveTopic(Topic topic);
}
