package com.isep.acme.model;

public class VoteReviewDTO {

    private Long userID;
    private String vote;


    public VoteReviewDTO(Long userID, String vote) {
        this.userID = userID;
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
}