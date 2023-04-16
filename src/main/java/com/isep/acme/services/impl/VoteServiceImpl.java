package com.isep.acme.services.impl;

import com.isep.acme.constants.Constants;
import com.isep.acme.model.Review;
import com.isep.acme.model.Vote;
import com.isep.acme.model.dtos.VoteReviewDTO;
import com.isep.acme.model.mappers.VoteMapper;
import com.isep.acme.repositories.ReviewRepository;
import com.isep.acme.repositories.VoteRepository;
import com.isep.acme.services.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository voteRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    RabbitTemplate rabbitTemplate;

    private static final VoteMapper VOTE_MAPPER = VoteMapper.INSTANCE;

    @Override
    public boolean createVote(String RID, VoteReviewDTO voteReviewDTO){
        if(voteReviewDTO != null){
            Optional<Review> review = reviewRepository.findByRID(RID);
            if (!review.isEmpty()){
                Vote vote = new Vote(voteReviewDTO.getVote(), voteReviewDTO.getUserID());
                if (voteReviewDTO.getVote().equalsIgnoreCase("upVote") && review.get().addUpVote(vote)
                        || voteReviewDTO.getVote().equalsIgnoreCase("downVote") && review.get().addDownVote(vote)) {
                    voteReviewDTO = VOTE_MAPPER.toVoteReviewDTO(voteRepository.save(vote));
                    voteReviewDTO.setRID(review.get().getRID());
                    if(voteReviewDTO != null){
                        reviewRepository.save(review.get());
                        rabbitTemplate.convertAndSend(Constants.EXCHANGE, "", voteReviewDTO, createMessageProcessor(Constants.VOTE_HEADER));

                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public MessagePostProcessor createMessageProcessor(String header) {
        return message -> {
            message.getMessageProperties().setHeader("action", header);
            return message;
        };
    }

    @Transactional
    public boolean addVoteToReview(VoteReviewDTO voteReviewDTO, Vote vote) {

        Optional<Review> review = this.reviewRepository.findByRID(voteReviewDTO.getRID());

        if (review.isEmpty()) return false;

        if (voteReviewDTO.getVote().equalsIgnoreCase("upVote") && review.get().addUpVote(vote)
                || voteReviewDTO.getVote().equalsIgnoreCase("downVote") && review.get().addDownVote(vote)) {

            reviewRepository.save(review.get());
            return true;

        }
        return false;
    }
}