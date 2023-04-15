package com.isep.acme.rabbit.listeners;

import com.isep.acme.model.Review;

public interface ReviewListener {

    void listenedReview(Review review, String action);
}
