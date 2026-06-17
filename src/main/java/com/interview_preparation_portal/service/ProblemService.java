package com.interview_preparation_portal.service;

import com.interview_preparation_portal.entity.Problem;

import java.util.List;

public interface ProblemService {

    Problem saveProblem(Problem problem);

    List<Problem> getAllProblems();

    Problem getProblemById(Long id);

    void deleteProblem(Long id);

    List<Problem> searchProblems(
            String keyword);
}
