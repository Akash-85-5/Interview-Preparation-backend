package com.interview_preparation_portal.service;

import com.interview_preparation_portal.dto.DashboardResponse;
import com.interview_preparation_portal.dto.TopicProgressDTO;

import java.util.List;

public interface DashboardService {

    DashboardResponse getDashboard(
            Long userId);

    List<TopicProgressDTO>
    getTopicProgress(
            Long userId);
}
