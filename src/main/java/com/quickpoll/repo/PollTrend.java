package com.quickpoll.repo;

public interface PollTrend {
    String getPollId();
    String getPollQuestion();
    String getPollName();
    Integer getTotalVotes();
    String getCreatedBy();
}