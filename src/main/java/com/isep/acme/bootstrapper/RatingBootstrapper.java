package com.isep.acme.bootstrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.isep.acme.model.Rating;
import com.isep.acme.repositories.RatingRepository;

@Component
public class RatingBootstrapper implements CommandLineRunner {

    @Autowired
    private RatingRepository repository;

    @Override
    public void run(String... args) throws Exception {

        if(repository.findByRate(0.5).isEmpty()) {
            Rating rate05 = new Rating(0.5);
            repository.save(rate05);
        }

        if(repository.findByRate(1.0).isEmpty()) {
            Rating rate1 = new Rating(1.0);
            repository.save(rate1);
        }

        if(repository.findByRate(1.5).isEmpty()) {
            Rating rate15 = new Rating(1.5);
            repository.save(rate15);
        }

        if(repository.findByRate(2.0).isEmpty()) {
            Rating rate2 = new Rating(2.0);
            repository.save(rate2);
        }

        if(repository.findByRate(2.5).isEmpty()) {
            Rating rate25 = new Rating(2.5);
            repository.save(rate25);
        }

        if(repository.findByRate(3.0).isEmpty()) {
            Rating rate3 = new Rating(3.0);
            repository.save(rate3);
        }

        if(repository.findByRate(3.5).isEmpty()) {
            Rating rate35 = new Rating(3.5);
            repository.save(rate35);
        }

        if(repository.findByRate(4.0).isEmpty()) {
            Rating rate4 = new Rating(4.0);
            repository.save(rate4);
        }

        if(repository.findByRate(4.5).isEmpty()) {
            Rating rate45 = new Rating(4.5);
            repository.save(rate45);
        }

        if(repository.findByRate(5.0).isEmpty()) {
            Rating rate5 = new Rating(5.0);
            repository.save(rate5);
        }
    }
}
