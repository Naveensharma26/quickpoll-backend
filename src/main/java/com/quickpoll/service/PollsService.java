package com.quickpoll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quickpoll.entity.Polls;
import com.quickpoll.entity.PollsResponse;
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
		Polls resp = pr.save(p);
		return resp;
	} 
	
	public PollsResponse getPollById(String pollId) {
		Polls p = pr.findById(pollId).orElse(null);
		PollsResponse resp = new PollsResponse();
		if (p == null) {
			return null; 
	    }
		resp.setIs_anonymous(p.getIs_anonymous());
		resp.setCreated_at(p.getCreated_at());
		resp.setCreated_by(p.getCreated_by());
		resp.setPoll_id(p.getPoll_id());
		resp.setPoll_name(p.getPoll_name());
		resp.setPoll_question(p.getPoll_question());
		return resp;
	}
	
	public boolean verifyUser(String pollId,String password) {
		Polls p = pr.findById(pollId).orElseThrow();
		return encoder.matches(password,p.getPassword());
		
	}
	
	public List<PollsResponse> getTrendingPolls(){
		List<Polls> list = pr.findTopPublicPolls();
		List<PollsResponse> responseList = list.stream().map(p -> {
	        PollsResponse resp = new PollsResponse();
	        resp.setPoll_id(p.getPoll_id());
	        resp.setPoll_name(p.getPoll_name());
	        resp.setPoll_question(p.getPoll_question());
	        resp.setCreated_by(p.getCreated_by());
	        resp.setCreated_at(p.getCreated_at());
	        resp.setIs_anonymous(p.getIs_anonymous());
	        resp.setIs_public(p.getIs_public());
	        return resp;
	    }).toList();
		return responseList;
	}
	
}
