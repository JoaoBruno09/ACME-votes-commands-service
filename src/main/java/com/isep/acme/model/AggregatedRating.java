package com.isep.acme.model;


import javax.persistence.*;

@Entity
public class AggregatedRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aggregatedId;

    @Column()
    private double average;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Product product;

    protected AggregatedRating() {}

    public AggregatedRating(double average, Product product) {
        this.average = average;
        this.product = product;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getAggregatedId() {
        return aggregatedId;
    }
}
