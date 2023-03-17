package com.isep.acme.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.isep.acme.model.*;
import com.isep.acme.services.ReviewService;

import java.util.List;


@Tag(name = "Review", description = "Endpoints for managing Review")
@RestController
class ReviewController {

    @Autowired
    private ReviewService rService;

    @Operation(summary = "finds a product through its sku and shows its review by status")
    @GetMapping("/products/{sku}/reviews/{status}")
    public ResponseEntity<List<ReviewDTO>> findById(@PathVariable(value = "sku") final String sku, @PathVariable(value = "status") final String status) {

        final var review = rService.getReviewsOfProduct(sku, status);

        return ResponseEntity.ok().body( review );
    }

    @Operation(summary = "gets review by user")
    @GetMapping("/reviews/{userID}")
    public ResponseEntity<List<ReviewDTO>> findReviewByUser(@PathVariable(value = "userID") final Long userID) {

        final var review = rService.findReviewsByUser(userID);

        return ResponseEntity.ok().body(review);
    }

    @Operation(summary = "creates review")
    @PostMapping("/products/{sku}/reviews")
    public ResponseEntity<ReviewDTO> createReview(@PathVariable(value = "sku") final String sku, @RequestBody CreateReviewDTO createReviewDTO) {

        final var review = rService.create(createReviewDTO, sku);

        if(review == null){
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<ReviewDTO>(review, HttpStatus.CREATED);
    }

    @Operation(summary = "add vote")
    @PutMapping("/reviews/{reviewID}/vote")
    public ResponseEntity<Boolean> addVote(@PathVariable(value = "reviewID") final Long reviewID, @RequestBody VoteReviewDTO voteReviewDTO){

        boolean added = this.rService.addVoteToReview(reviewID, voteReviewDTO);

        if(!added){
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<Boolean>(added, HttpStatus.CREATED);
    }

    @Operation(summary = "deletes review")
    @DeleteMapping("/reviews/{reviewID}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable(value = "reviewID") final Long reviewID) {

        Boolean rev = rService.DeleteReview(reviewID);

        if (rev == null) return ResponseEntity.notFound().build();

        if (rev == false) return ResponseEntity.unprocessableEntity().build();

        return ResponseEntity.ok().body(rev);
    }

    @Operation(summary = "gets pedding reviews")
    @GetMapping("/reviews/pending")
    public ResponseEntity<List<ReviewDTO>> getPendingReview(){

        List<ReviewDTO> r = rService.findPendingReview();

        return ResponseEntity.ok().body(r);
    }

    @Operation(summary = "Accept or reject review")
    @PutMapping("/reviews/acceptreject/{reviewID}")
    public ResponseEntity<ReviewDTO> putAcceptRejectReview(@PathVariable(value = "reviewID") final Long reviewID, @RequestBody String approved){

        try {
            ReviewDTO rev = rService.moderateReview(reviewID, approved);

            return ResponseEntity.ok().body(rev);
        }
        catch( IllegalArgumentException e ) {
            return ResponseEntity.badRequest().build();
        }
        catch( ResourceNotFoundException e ) {
            return ResponseEntity.notFound().build();
        }
    }
}
