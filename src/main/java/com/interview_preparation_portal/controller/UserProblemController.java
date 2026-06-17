package com.interview_preparation_portal.controller;

import com.interview_preparation_portal.entity.UserProblem;
import com.interview_preparation_portal.service.UserProblemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-problems")
@CrossOrigin("*")
public class UserProblemController {

    private final UserProblemService service;

    public UserProblemController(
            UserProblemService service) {
        this.service = service;
    }

    @PostMapping
    public UserProblem save(
            @RequestBody UserProblem userProblem) {

        return service.saveOrUpdate(
                userProblem);
    }

    @GetMapping("/{userId}")
    public List<UserProblem> getByUser(
            @PathVariable Long userId) {

        return service.getByUser(userId);
    }

    @PutMapping("/{id}/notes")
    public UserProblem updateNotes(
            @PathVariable Long id,
            @RequestBody UserProblem request) {

        return service.updateNotes(
                id,
                request.getNotes());
    }

    @GetMapping(
            "/user/{userId}/problem/{problemId}"
    )
    public UserProblem getByUserAndProblem(

            @PathVariable Long userId,

            @PathVariable Long problemId

    ) {

        return service.getByUserAndProblem(
                userId,
                problemId);
    }
}
