package com.isep.acme.services;

import com.isep.acme.model.Vote;
import com.isep.acme.model.dtos.VoteReviewDTO;
import org.springframework.amqp.core.MessagePostProcessor;

import javax.transaction.Transactional;

public interface VoteService {
    boolean createVote(String RID, VoteReviewDTO voteReviewDTO);

    MessagePostProcessor createMessageProcessor(String header);

    @Transactional
    boolean addVoteToReview(VoteReviewDTO voteReviewDTO, Vote vote);
}