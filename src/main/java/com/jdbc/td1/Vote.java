package com.jdbc.td1;

import java.util.Objects;

public class Vote {
    private int id;
    private Candidate candidate;
    private Voter voter;
    private Vote_type voteType;

    public Vote() {}
    public Vote(int id, Candidate candidate, Voter voter, Vote_type voteType) {
        this.id = id;
        this.candidate = candidate;
        this.voter = voter;
        this.voteType = voteType;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Voter getVoter() {
        return voter;
    }
    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public Vote_type getVoteType() {
        return voteType;
    }
    public void setVoteType(Vote_type voteType) {
        this.voteType = voteType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return id == vote.id && Objects.equals(candidate, vote.candidate) && Objects.equals(voter, vote.voter) && voteType == vote.voteType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, candidate, voter, voteType);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", candidate=" + candidate +
                ", voter=" + voter +
                ", voteType=" + voteType +
                '}';
    }
}
