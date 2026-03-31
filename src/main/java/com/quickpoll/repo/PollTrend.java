package com.quickpoll.repo;

public interface PollTrend {
    String getPoll_id();
    String getPoll_question();
    String getPoll_name();
    Integer getTotal_votes();
    String getCreated_by();
}