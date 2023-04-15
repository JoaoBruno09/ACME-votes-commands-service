package com.isep.acme.rabbit.listeners;

import com.isep.acme.model.Vote;

public interface VoteListener {

    void listenedVote(String RID, Vote vote);
}
