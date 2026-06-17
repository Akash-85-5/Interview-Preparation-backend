package com.interview_preparation_portal.repository;

import com.interview_preparation_portal.entity.UserProblem;
import com.interview_preparation_portal.enums.ProblemStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProblemRepository
        extends JpaRepository<UserProblem, Long> {
    List<UserProblem> findByUserId(Long userId);

    long countByUserIdAndStatus(
            Long userId,
            ProblemStatus status);

    Optional<UserProblem>
    findByUserIdAndProblemId(
            Long userId,
            Long problemId);
}