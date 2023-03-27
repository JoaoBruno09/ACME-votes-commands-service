package com.isep.acme.controllers;


import com.isep.acme.model.dtos.VoteReviewDTO;
import com.isep.acme.services.VoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Vote", description="Endpoints for managing votes")
@RestController
@RequestMapping("/reviews/{idReview}/vote")
@RequiredArgsConstructor
public class VoteController {
    @Autowired
    private VoteService voteService;

@PutMapping
@ResponseStatus(HttpStatus.CREATED)
    public void createVote(@PathVariable(value = "idReview") final long idReview, @RequestBody VoteReviewDTO voteReviewDTO){
        voteService.createVote(idReview,voteReviewDTO);
    }
}
