package com.isep.acme.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long voteID;
    private String vote;
    private Long userID;
    private String VID;

    public Vote(String vote, Long userID) {
        this.vote = vote;
        this.userID = userID;
        setVID("V" + UUID.randomUUID().toString().substring(0,8));
    }


}
