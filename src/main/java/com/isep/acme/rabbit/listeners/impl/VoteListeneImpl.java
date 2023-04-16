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

import javax.transaction.Transactional;
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
                Vote voteToAdd = voteRepository.save(vote);
                if (addVoteToReview(RID, voteToAdd)) {
                    System.out.println("Vote Added " + voteToAdd);
                }
            }
        }
    }

    @Transactional
    private boolean addVoteToReview(String RID, Vote vote) {
        Optional<Review> review = this.reviewRepository.findByRID(RID);

        if (review.isEmpty()) return false;

        if (vote.getVote().equalsIgnoreCase("upVote") && review.get().addUpVote(vote)
                || vote.getVote().equalsIgnoreCase("downVote") && review.get().addDownVote(vote)) {
            reviewRepository.save(review.get());
            return true;
        }
        return false;
    }
}