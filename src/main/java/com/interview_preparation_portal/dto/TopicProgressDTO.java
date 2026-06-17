package com.interview_preparation_portal.dto;

public class TopicProgressDTO {

    private String topicName;

    private long totalProblems;

    private long solvedProblems;

    public TopicProgressDTO() {
    }

    public TopicProgressDTO(
            String topicName,
            long totalProblems,
            long solvedProblems) {

        this.topicName =
                topicName;

        this.totalProblems =
                totalProblems;

        this.solvedProblems =
                solvedProblems;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(
            String topicName) {

        this.topicName =
                topicName;
    }

    public long getTotalProblems() {
        return totalProblems;
    }

    public void setTotalProblems(
            long totalProblems) {

        this.totalProblems =
                totalProblems;
    }

    public long getSolvedProblems() {
        return solvedProblems;
    }

    public void setSolvedProblems(
            long solvedProblems) {

        this.solvedProblems =
                solvedProblems;
    }
}