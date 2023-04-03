package com.isep.acme.rabbit;

import com.isep.acme.model.Vote;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RMQListener {

    @RabbitListener(queues = RMQConfig.VCQUEUE)
    public void listener(Vote vote){
        System.out.println("Vote" + vote);
        System.out.println("Vote ID" + vote.getVoteID());
    }
}