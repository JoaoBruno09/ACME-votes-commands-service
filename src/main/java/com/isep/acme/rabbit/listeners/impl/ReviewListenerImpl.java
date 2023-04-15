package com.isep.acme.rabbit.listeners.impl;

import com.isep.acme.constants.Constants;
import com.isep.acme.model.Review;
import com.isep.acme.rabbit.listeners.ReviewListener;
import com.isep.acme.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ReviewListenerImpl implements ReviewListener {

    @Autowired
    private final ReviewRepository reviewRepository;

    @Override
    public void listenedReview(Review review, String action) {
        if(review != null){
            final Optional<Review> reviewToAction = reviewRepository.findByRID(review.getRID());
            switch(action) {
                case Constants.CREATED_REVIEW_HEADER:
                    if(reviewToAction.isEmpty()){
                        reviewRepository.save(review);
                        System.out.println("Review Added " + review);
                    }
                    break;
                case Constants.MODERATED_REVIEW_HEADER:
                    if(!reviewToAction.isEmpty()){
                        reviewToAction.get().setApprovalStatus(review.getApprovalStatus());
                        reviewRepository.save(reviewToAction.get());
                        System.out.println("Review Updated " + reviewToAction.get());
                    }
                    break;
                case Constants.DELETED_REVIEW_HEADER:
                    if(!reviewToAction.isEmpty()){
                        Review r = reviewToAction.get();
                        reviewRepository.delete(r);
                        System.out.println("Review Deleted " + reviewToAction.get());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}