package com.interview_preparation_portal.repository;

import com.interview_preparation_portal.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemRepository
        extends JpaRepository<Problem, Long> {

    List<Problem> findByTitleContainingIgnoreCase(
            String title);
}
