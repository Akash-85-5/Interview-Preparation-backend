package com.interview_preparation_portal.repository;

import com.interview_preparation_portal.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository
        extends JpaRepository<Topic, Long> {
}
