package com.isep.acme.rabbit.listeners;

import com.isep.acme.model.dtos.VoteReviewDTO;

public interface VoteListener {

    void listenedVote(VoteReviewDTO voteReviewDTO);
}
