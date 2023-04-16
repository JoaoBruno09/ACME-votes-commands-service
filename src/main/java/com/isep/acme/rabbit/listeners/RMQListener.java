package com.isep.acme.rabbit.listeners;

import com.isep.acme.constants.Constants;
import com.isep.acme.model.Product;
import com.isep.acme.model.Review;
import com.isep.acme.model.User;
import com.isep.acme.model.Vote;
import com.isep.acme.model.dtos.ReviewDTO;
import com.isep.acme.model.dtos.VoteReviewDTO;
import com.isep.acme.model.mappers.ReviewMapper;
import com.isep.acme.model.mappers.VoteMapper;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class RMQListener {

    private final MessageConverter messageConverter;
    private final ProductListener productListener;
    private final ReviewListener reviewListener;
    private final VoteListener voteListener;
    @Autowired
    ProductRepository pRepository;
    @Autowired
    UserRepository uRepository;

    private static final VoteMapper VOTE_MAPPER = VoteMapper.INSTANCE;

    @RabbitListener(queues = "#{queue.name}")
    public void listener(Message message){
        final String action= message.getMessageProperties().getHeader("action");
        if (action.equals(Constants.CREATED_PRODUCT_HEADER)
                || action.equals(Constants.UPDATED_PRODUCT_HEADER)
                || action.equals(Constants.DELETED_PRODUCT_HEADER)) {
            final Product product = (Product) messageConverter.fromMessage(message);
            System.out.println("Received Product Message " + product);
            productListener.listenedProduct(product, action);
        } else if (action.equals(Constants.CREATED_REVIEW_HEADER)
                || action.equals(Constants.MODERATED_REVIEW_HEADER)
                || action.equals(Constants.DELETED_REVIEW_HEADER)) {
            final ReviewDTO reviewDTO = (ReviewDTO) messageConverter.fromMessage(message);
            Review review = getProductAndUserForReview(reviewDTO);
            System.out.println("Received Review Message " + review);
            reviewListener.listenedReview(review, action);
        }else if (action.equals(Constants.VOTE_HEADER)){
            final VoteReviewDTO voteDTO = (VoteReviewDTO) messageConverter.fromMessage(message);
            System.out.println("Received Vote Message " + voteDTO);
            voteListener.listenedVote(voteDTO);
        }
    }

    private Review getProductAndUserForReview(ReviewDTO reviewDTO){
        final Optional<Product> product = pRepository.findBySku(reviewDTO.getProductSku());
        final Optional<User> user = uRepository.findById(reviewDTO.getUserId());
        Review review = ReviewMapper.toReview(reviewDTO);
        review.setUser(user.get());
        review.setProduct(product.get());
        return review;
    }
}