package com.quickpoll.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quickpoll.entity.PollRequest;
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
	
	public Polls addPoll(PollRequest req) {

	    Polls p = new Polls(); 
	    p.setPollId(req.getPollId());
	    p.setPollName(req.getPollName());
	    p.setPollQuestion(req.getPollQuestion());
	    p.setCreatedBy(req.getCreatedBy());
	    p.setIsAnonymous(req.getIsAnonymous());
	    p.setIsPublic(req.getIsPublic());

	    String hashedPassword = encoder.encode(req.getPassword());
	    p.setPassword(hashedPassword);

	    LocalDateTime now = LocalDateTime.now();
	    p.setCreatedAt(now);

	    if (req.getDuration() == null || req.getDuration() == 0) {
	        p.setExpiresAt(null); // never
	    } else {
	        p.setExpiresAt(now.plusHours(req.getDuration()));
	    }

	    return pr.save(p);
	}
	
	public PollsResponse getPollById(String pollId) {
		Polls p = pr.findById(pollId).orElse(null);
		PollsResponse resp = new PollsResponse();
		if (p == null) {
			return null; 
	    }
		resp.setIsAnonymous(p.getIsAnonymous());
		resp.setCreatedAt(p.getCreatedAt());
		resp.setCreatedBy(p.getCreatedBy());
		resp.setPollId(p.getPollId());
		resp.setPollName(p.getPollName());
		resp.setPollQuestion(p.getPollQuestion());
		resp.setIsPublic(p.getIsPublic());
		resp.setExpiresAt(p.getExpiresAt());
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
