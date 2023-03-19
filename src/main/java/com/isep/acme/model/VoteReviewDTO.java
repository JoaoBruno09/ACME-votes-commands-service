package com.isep.acme.model;

public class VoteReviewDTO {

    private Long userID;
    private String vote;
    private Long voteID;


    public VoteReviewDTO(Long userID, Long voteID, String vote) {
        this.userID = userID;
        this.voteID = voteID;
        this.vote = vote;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Long getVoteID() {
        return voteID;
    }

    public void setVoteID(Long voteID) {
        this.voteID = voteID;
    }
}