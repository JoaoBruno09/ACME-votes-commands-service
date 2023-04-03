package com.isep.acme.services.impl;

import com.isep.acme.model.Vote;
import com.isep.acme.model.dtos.VoteReviewDTO;
import com.isep.acme.repositories.VoteRepository;
import com.isep.acme.services.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public VoteReviewDTO createVote(Long idReview, VoteReviewDTO voteReviewDTO){

        Vote vote = new Vote(voteReviewDTO.getVote(), voteReviewDTO.getVoteID(), voteReviewDTO.getUserID());

        if (voteReviewDTO.getVote().equalsIgnoreCase("upVote")
                || voteReviewDTO.getVote().equalsIgnoreCase("downVote")){

            voteRepository.save(vote);
            log.info("Vote" + vote.getVoteID() + "is saved on DataBase");
        }
        return null;
    }
}