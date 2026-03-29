package com.quickpoll.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.quickpoll.entity.PollVote;

@Repository
public interface PollVoteRepo extends JpaRepository<PollVote, Integer>{
	
	public List<PollVote> getPollVoteByPollId(String pollId);

}
