package com.quickpoll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.quickpoll.entity.PollOptions;
import com.quickpoll.entity.PollVote;
import com.quickpoll.entity.Polls;
import com.quickpoll.repo.PollOptionsRepo;
import com.quickpoll.repo.PollVoteRepo;
import com.quickpoll.repo.PollsRepo;

import jakarta.transaction.Transactional;

@Service
public class PollVoteService {

	@Autowired
	PollVoteRepo repo;
	
	@Autowired
	PollsRepo p;
	
	@Autowired
	PollOptionsRepo pollOptionsRepo;
	
	public PollVote voteOption(PollVote pv) {
		return repo.save(pv);
	}
	
	public List<PollVote> getPollResult(String pollId){
		return repo.getPollVoteByPollId(pollId);
	}
	
	@Transactional
	public void vote(PollVote pv) {
	    
	    PollOptions option = pollOptionsRepo.findById(pv.getPollOptionsId())
	        .orElseThrow(() -> new RuntimeException("Option not found"));

	    Polls poll = p.findByPollId(pv.getPollId());
//	    if (poll.getExpiresAt().isBefore(LocalDateTime.now())) {
//	        throw new RuntimeException("Poll expired");
//	    }

	    repo.save(pv);

	   option.setVoteCount(option.getVoteCount() + 1);
	    pollOptionsRepo.save(option);
	}
}
