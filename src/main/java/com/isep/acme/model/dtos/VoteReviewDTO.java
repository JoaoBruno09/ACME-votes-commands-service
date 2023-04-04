package com.isep.acme.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VoteReviewDTO {
    private Long userID;
    private String vote;
    private Long voteID;
}