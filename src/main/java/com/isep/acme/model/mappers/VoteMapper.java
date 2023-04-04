package com.isep.acme.model.mappers;

import com.isep.acme.model.Vote;
import com.isep.acme.model.dtos.VoteReviewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VoteMapper {

    VoteMapper INSTANCE = Mappers.getMapper(VoteMapper.class);

    Vote toVote(VoteReviewDTO voteReviewDTO);
    VoteReviewDTO toVoteReviewDTO(Vote vote);
}
