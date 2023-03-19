package com.isep.acme.services;

import com.isep.acme.model.VoteReviewDTO;

public interface VoteService {
    VoteReviewDTO createVote(Long idReview, VoteReviewDTO voteReviewDTO);
}