package com.isep.acme.services.impl;

import com.isep.acme.model.Vote;
import com.isep.acme.model.dtos.VoteReviewDTO;
import com.isep.acme.model.mappers.VoteMapper;
import com.isep.acme.rabbit.RMQConfig;
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

    private static final VoteMapper VOTE_MAPPER = VoteMapper.INSTANCE;

    @Override
    public VoteReviewDTO createVote(Long idReview, VoteReviewDTO voteReviewDTO){

        Vote vote = VOTE_MAPPER.toVote(voteReviewDTO);
        if (vote.getVote().equalsIgnoreCase("upVote")
                || vote.getVote().equalsIgnoreCase("downVote")){
            voteRepository.save(vote);
            log.info("Vote" + vote.getVoteID() + "is saved on DataBase");
            this.rabbitTemplate.convertAndSend(RMQConfig.EXCHANGE, "", vote);
        }
        return null;
    }
}