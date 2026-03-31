package com.quickpoll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quickpoll.entity.PollTrend;
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
	
	public List<PollTrend> getTrendingPolls(){
		List<PollTrend> list = pr.findTopPublicPolls();
		List<PollTrend> responseList = list.stream().map(p -> {
			PollTrend resp = new PollTrend();
	        resp.setPoll_id(p.getPoll_id());
	        resp.setPoll_question(p.getPoll_question());
	        resp.setTotal_votes(p.getTotal_votes());
	        resp.setPoll_name(p.getPoll_name());
	        return resp;
	    }).toList();
		return responseList;
	}
	
}
