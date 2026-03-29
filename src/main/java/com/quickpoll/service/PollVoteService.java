package com.quickpoll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.quickpoll.entity.PollVote;
import com.quickpoll.repo.PollVoteRepo;

@Service
public class PollVoteService {

	@Autowired
	PollVoteRepo repo;
	
	public PollVote voteOption(PollVote pv) {
		return repo.save(pv);
	}
	
	public List<PollVote> getPollResult(String pollId){
		return repo.getPollVoteByPollId(pollId);
	}
}
