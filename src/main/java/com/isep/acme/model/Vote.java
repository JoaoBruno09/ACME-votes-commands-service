package com.isep.acme.model;

import javax.persistence.Embeddable;
import javax.persistence.*;

import java.util.Objects;

@Entity
@Embeddable
public class Vote {
    private String vote;
    private Long userID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long voteID;


    protected Vote() {

    }

    public Vote(String vote, Long voteID, Long userID) {
        this.vote = vote;
        this.voteID = voteID;
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote1 = (Vote) o;
        return vote.equals(vote1.vote) && voteID.equals(vote1.voteID) && userID.equals(vote1.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vote, voteID, userID);
    }

}
