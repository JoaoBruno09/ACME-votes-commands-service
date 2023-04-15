package com.isep.acme.model.dtos;

import com.isep.acme.model.Product;
import com.isep.acme.model.User;

import java.io.Serializable;
import java.time.LocalDate;

public class ReviewDTO implements Serializable {

    private Long idReview;
    private String RID;
    private long version;
    private String reviewText;
    private LocalDate publishingDate;
    private String approvalStatus;
    private String funFact;
    private Integer vote;
    private String productSku;
    private Long userId;

    public ReviewDTO() {
    }

    public ReviewDTO(Long idReview, String rId, String reviewText, LocalDate publishingDate, String approvalStatus, Product product, String funFact, User user, Integer vote) {
        this.idReview = idReview;
        this.RID = rId;
        this.reviewText = reviewText;
        this.publishingDate = publishingDate;
        this.approvalStatus = approvalStatus;
        this.funFact = funFact;
        this.vote = vote;
        this.productSku = product.getSku();
        this.userId = user.getUserId();
    }

    public void setIdReview( Long idReview ) {
        this.idReview = idReview;
    }

    public Long getIdReview() {
        return this.idReview;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

}
