package com.isep.acme.services;

import com.isep.acme.model.dtos.VoteReviewDTO;
import org.springframework.amqp.core.MessagePostProcessor;

public interface VoteService {
    boolean createVote(String RID, VoteReviewDTO voteReviewDTO);

    MessagePostProcessor createMessageProcessor(String header);
}