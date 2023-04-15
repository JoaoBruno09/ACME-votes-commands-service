package com.isep.acme.repositories;

import com.isep.acme.model.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VoteRepository extends CrudRepository<Vote, Long> {
    Optional<Vote> findByVID(String vId);
}