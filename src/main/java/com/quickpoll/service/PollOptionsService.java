package com.quickpoll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickpoll.entity.PollOptions;
import com.quickpoll.repo.PollOptionsRepo;

@Service
public class PollOptionsService {

	@Autowired
	PollOptionsRepo repo;
	
	public List<PollOptions> addOptions(List<PollOptions> list) {
		return repo.saveAll(list);
	}
	
	public List<PollOptions> getOptionsByPollId(String pollId) {
		return repo.findAllByPollId(pollId);
	}
	
	public PollOptions updateCount(PollOptions p) {
		PollOptions exist = repo.findById(p.getPoll_options_id()).orElse(null);
		if(exist!=null) {
			exist.setVote_count(p.getVote_count());
			exist = repo.save(exist);
		}
		return exist;
	}
}
