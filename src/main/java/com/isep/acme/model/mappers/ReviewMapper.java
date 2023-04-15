package com.isep.acme.model.mappers;

import com.isep.acme.model.Review;
import com.isep.acme.model.dtos.ReviewDTO;

import java.util.ArrayList;
import java.util.List;

public class ReviewMapper {

    public static ReviewDTO toDto(Review review){
        return new ReviewDTO(
                review.getIdReview(),
                review.getRID(),
                review.getReviewText(),
                review.getPublishingDate(),
                review.getApprovalStatus(),
                review.getProduct(),
                review.getFunFact(),
                review.getUser(),
                review.getUpVote().size());
    }

    public static Review toReview(ReviewDTO reviewDTO){
        return new Review(
                reviewDTO.getIdReview(),
                reviewDTO.getRID(),
                reviewDTO.getVersion(),
                reviewDTO.getApprovalStatus(),
                reviewDTO.getReviewText(),
                reviewDTO.getPublishingDate(),
                reviewDTO.getProductSku(),
                reviewDTO.getFunFact(),
                reviewDTO.getUserId());
    }

    public static List<ReviewDTO> toDtoList(List<Review> review) {
        List<ReviewDTO> dtoList = new ArrayList<>();

        for (Review rev: review) {
            dtoList.add(toDto(rev));
        }
        return dtoList;
    }
}
