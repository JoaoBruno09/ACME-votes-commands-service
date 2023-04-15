package com.isep.acme.rabbit.listeners.impl;

import com.isep.acme.model.Review;
import com.isep.acme.model.Vote;
import com.isep.acme.model.mappers.VoteMapper;
import com.isep.acme.rabbit.listeners.VoteListener;
import com.isep.acme.repositories.ReviewRepository;
import com.isep.acme.repositories.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class VoteListeneImpl implements VoteListener {

    @Autowired
    private final VoteRepository voteRepository;
    @Autowired
    ReviewRepository reviewRepository;

    private static final VoteMapper VOTE_MAPPER = VoteMapper.INSTANCE;

    @Override
    public void listenedVote(String RID, Vote vote) {
        if(vote != null){
            final Optional<Vote> voteToAction = voteRepository.findByVID(vote.getVID());
            if(voteToAction.isEmpty()){
                Optional<Review> review = reviewRepository.findByRID(RID);
                if (!review.isEmpty()){
                    if (vote.getVote().equalsIgnoreCase("upVote") && review.get().addUpVote(vote)
                            || vote.getVote().equalsIgnoreCase("downVote") && review.get().addDownVote(vote)) {
                        voteRepository.save(vote);
                        reviewRepository.save(review.get());
                        System.out.println("Vote Added " + vote);
                    }
                }
            }
        }
    }
}