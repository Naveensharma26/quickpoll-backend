package com.quickpoll.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quickpoll.entity.Polls;
import com.quickpoll.entity.PollsResponse;
import com.quickpoll.repo.PollTrend;
import com.quickpoll.repo.PollsRepo;

@Service
public class PollsService {
	
	@Autowired
	PollsRepo pr;
	
	@Autowired
	PasswordEncoder encoder;
	
	public Polls addPoll(Polls p) {
		String hashedPassword = encoder.encode(p.getPassword());
		p.setPassword(hashedPassword);
		p.setCreatedAt(LocalDateTime.now());
		Polls resp = pr.save(p);
		return resp;
	} 
	
	public PollsResponse getPollById(String pollId) {
		Polls p = pr.findById(pollId).orElse(null);
		PollsResponse resp = new PollsResponse();
		if (p == null) {
			return null; 
	    }
		resp.setIsAnonymous(p.getIsAnonymous());
		resp.setCreatedAt(p.getCreatedAt().toString());
		resp.setCreatedBy(p.getCreatedBy());
		resp.setPollId(p.getPollId());
		resp.setPollName(p.getPollName());
		resp.setPollQuestion(p.getPollQuestion());
		return resp;
	}
	
	public boolean verifyUser(String pollId,String password) {
		Polls p = pr.findById(pollId).orElseThrow();
		return encoder.matches(password,p.getPassword());
		
	}
	
	public List<PollTrend> getTrendingPolls() {
	    return pr.findTopPublicPolls();
	}
	
}
