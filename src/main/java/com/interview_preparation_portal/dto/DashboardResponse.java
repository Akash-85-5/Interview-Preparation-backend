package com.interview_preparation_portal.dto;

public class DashboardResponse {
    private long totalProblems;

    private long solvedProblems;

    private long revisionProblems;

    private long unsolvedProblems;

    public long getTotalProblems() {
        return totalProblems;
    }

    public void setTotalProblems(long totalProblems) {
        this.totalProblems = totalProblems;
    }

    public long getSolvedProblems() {
        return solvedProblems;
    }

    public void setSolvedProblems(long solvedProblems) {
        this.solvedProblems = solvedProblems;
    }

    public long getRevisionProblems() {
        return revisionProblems;
    }

    public void setRevisionProblems(long revisionProblems) {
        this.revisionProblems = revisionProblems;
    }

    public long getUnsolvedProblems() {
        return unsolvedProblems;
    }

    public void setUnsolvedProblems(long unsolvedProblems) {
        this.unsolvedProblems = unsolvedProblems;
    }
}
