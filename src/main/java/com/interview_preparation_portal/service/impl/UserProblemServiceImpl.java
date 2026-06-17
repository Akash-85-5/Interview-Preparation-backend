package com.interview_preparation_portal.service.impl;

import com.interview_preparation_portal.entity.UserProblem;
import com.interview_preparation_portal.repository.UserProblemRepository;
import com.interview_preparation_portal.service.UserProblemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProblemServiceImpl
        implements UserProblemService {

    private final UserProblemRepository repository;

    public UserProblemServiceImpl(
            UserProblemRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserProblem save(
            UserProblem userProblem) {

        return repository.save(userProblem);
    }

    @Override
    public List<UserProblem> getByUser(
            Long userId) {

        return repository.findByUserId(userId);
    }
    @Override
    public UserProblem updateNotes(
            Long id,
            String notes) {

        UserProblem userProblem =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User Problem Not Found"));

        userProblem.setNotes(notes);

        return repository.save(
                userProblem);
    }
    @Override
    public UserProblem getByUserAndProblem(
            Long userId,
            Long problemId) {

        return repository
                .findByUserIdAndProblemId(
                        userId,
                        problemId)
                .orElse(null);
    }

    @Override
    public UserProblem saveOrUpdate(
            UserProblem userProblem) {

        Optional<UserProblem> existing =
                repository.findByUserIdAndProblemId(

                        userProblem
                                .getUser()
                                .getId(),

                        userProblem
                                .getProblem()
                                .getId()
                );

        if(existing.isPresent()) {

            UserProblem existingRecord =
                    existing.get();

            existingRecord.setStatus(
                    userProblem.getStatus());

            existingRecord.setNotes(
                    userProblem.getNotes());

            existingRecord.setCompletedDate(
                    userProblem.getCompletedDate());

            return repository.save(
                    existingRecord);
        }

        return repository.save(
                userProblem);
    }
}
