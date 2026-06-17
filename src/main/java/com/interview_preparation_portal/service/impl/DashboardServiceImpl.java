package com.interview_preparation_portal.service.impl;

import com.interview_preparation_portal.dto.DashboardResponse;
import com.interview_preparation_portal.dto.TopicProgressDTO;
import com.interview_preparation_portal.entity.Topic;
import com.interview_preparation_portal.enums.ProblemStatus;
import com.interview_preparation_portal.repository.ProblemRepository;
import com.interview_preparation_portal.repository.TopicRepository;
import com.interview_preparation_portal.repository.UserProblemRepository;
import com.interview_preparation_portal.service.DashboardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardServiceImpl
        implements DashboardService {

    private final ProblemRepository problemRepository;

    private final UserProblemRepository userProblemRepository;
    private final TopicRepository topicRepository;


    public DashboardServiceImpl(
            ProblemRepository problemRepository,
            UserProblemRepository userProblemRepository,
            TopicRepository topicRepository) {

        this.problemRepository = problemRepository;
        this.userProblemRepository = userProblemRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public DashboardResponse getDashboard(
            Long userId) {

        long totalProblems =
                problemRepository.count();

        long solvedProblems =
                userProblemRepository
                        .countByUserIdAndStatus(
                                userId,
                                ProblemStatus.SOLVED);

        long revisionProblems =
                userProblemRepository
                        .countByUserIdAndStatus(
                                userId,
                                ProblemStatus.REVISION);

        long unsolvedProblems =
                totalProblems
                        - solvedProblems
                        - revisionProblems;

        DashboardResponse response =
                new DashboardResponse();

        response.setTotalProblems(
                totalProblems);

        response.setSolvedProblems(
                solvedProblems);

        response.setRevisionProblems(
                revisionProblems);

        response.setUnsolvedProblems(
                unsolvedProblems);

        return response;
    }

    @Override
    public List<TopicProgressDTO>
    getTopicProgress(
            Long userId) {

        List<Topic> topics =
                topicRepository.findAll();

        List<TopicProgressDTO> result =
                new ArrayList<>();

        for(Topic topic : topics) {

            long totalProblems =
                    topic.getProblems()
                            .size();

            long solvedProblems =
                    topic.getProblems()
                            .stream()
                            .filter(problem ->

                                    userProblemRepository
                                            .findByUserIdAndProblemId(
                                                    userId,
                                                    problem.getId())
                                            .isPresent()
                            )
                            .count();

            result.add(

                    new TopicProgressDTO(

                            topic.getName(),

                            totalProblems,

                            solvedProblems
                    )
            );
        }

        return result;
    }
}