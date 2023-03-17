package com.isep.acme.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

/* Code based on following tutorial https://attacomsian.com/blog/http-requests-resttemplate-spring-boot */

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getFunFact(LocalDate date) {
        String url = "http://numbersapi.com/{month}/{day}/date";
        return this.restTemplate.getForObject(url, String.class, date.getMonthValue(),date.getDayOfMonth());
    }
}
