package com.quickpoll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickpoll.entity.Polls;
import com.quickpoll.repo.PollsRepo;

@Service
public class PollsService {
	
	@Autowired
	PollsRepo pr;
	
	public Polls addPoll(Polls p) {
		Polls resp = pr.save(p);
		return resp;
	} 
	
	public List<Polls> getAllPolls(){
		return pr.findAll();
	}
	
	public Polls getPollById(String pollId) {
		return pr.findById(pollId).orElse(null);
	}
	
}
