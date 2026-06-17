package com.interview_preparation_portal.controller;

import com.interview_preparation_portal.dto.DashboardResponse;
import com.interview_preparation_portal.dto.TopicProgressDTO;
import com.interview_preparation_portal.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(
            DashboardService dashboardService) {

        this.dashboardService = dashboardService;
    }

    @GetMapping("/{userId}")
    public DashboardResponse getDashboard(
            @PathVariable Long userId) {

        return dashboardService
                .getDashboard(userId);
    }

    @GetMapping(
            "/topic-progress/{userId}"
    )
    public List<TopicProgressDTO>
    getTopicProgress(

            @PathVariable Long userId

    ) {

        return dashboardService
                .getTopicProgress(
                        userId);
    }
}
