package com.interview_preparation_portal.service.impl;

import com.interview_preparation_portal.entity.Problem;
import com.interview_preparation_portal.repository.ProblemRepository;
import com.interview_preparation_portal.service.ProblemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl
        implements ProblemService {

    private final ProblemRepository problemRepository;

    public ProblemServiceImpl(
            ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Override
    public Problem saveProblem(
            Problem problem) {
        return problemRepository.save(problem);
    }

    @Override
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    @Override
    public Problem getProblemById(Long id) {
        return problemRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Problem Not Found"));
    }

    @Override
    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }

    @Override
    public List<Problem> searchProblems(
            String keyword) {

        return problemRepository
                .findByTitleContainingIgnoreCase(
                        keyword);
    }
}
