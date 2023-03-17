package com.isep.acme.services;

import java.util.Optional;

import com.isep.acme.model.Rating;

public interface RatingService {

    Optional<Rating> findByRate(Double rate);
}
