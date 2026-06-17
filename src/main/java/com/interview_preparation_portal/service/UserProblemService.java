package com.interview_preparation_portal.service;

import com.interview_preparation_portal.entity.UserProblem;

import java.util.List;

public interface UserProblemService {

    UserProblem save(UserProblem userProblem);

    List<UserProblem> getByUser(Long userId);

    UserProblem updateNotes(
            Long id,
            String notes);

    UserProblem getByUserAndProblem(
            Long userId,
            Long problemId);
    UserProblem saveOrUpdate(
            UserProblem userProblem);
}
