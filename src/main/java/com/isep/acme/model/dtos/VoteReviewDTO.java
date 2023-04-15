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
    private Long voteID;
    private String VID;
    private String vote;
    private Long userID;
    private String RID;
}