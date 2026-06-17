package com.interview_preparation_portal.controller;

import com.interview_preparation_portal.entity.Problem;
import com.interview_preparation_portal.service.ProblemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems")
@CrossOrigin("*")
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(
            ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping
    public List<Problem> getAllProblems() {
        return problemService.getAllProblems();
    }

    @GetMapping("/{id}")
    public Problem getProblemById(
            @PathVariable Long id) {

        return problemService.getProblemById(id);
    }

    @PostMapping
    public Problem createProblem(
            @RequestBody Problem problem) {

        return problemService.saveProblem(problem);
    }

    @DeleteMapping("/{id}")
    public void deleteProblem(
            @PathVariable Long id) {

        problemService.deleteProblem(id);
    }

    @GetMapping("/search")
    public List<Problem> searchProblems(
            @RequestParam String keyword) {

        return problemService.searchProblems(
                keyword);
    }
}
