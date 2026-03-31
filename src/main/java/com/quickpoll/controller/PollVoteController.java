package com.quickpoll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickpoll.entity.PollVote;
import com.quickpoll.service.PollVoteService;

@CrossOrigin(origins = "*")
@RestController
public class PollVoteController {

	@Autowired
	PollVoteService service;
	
	@PostMapping("/voteOption")
	public PollVote voteOption(@RequestBody PollVote pv) {
		return service.voteOption(pv);
	}
	
	@GetMapping("/getVoteResult/{id}")
	public List<PollVote> getVoteResult(@PathVariable String id){
		return service.getPollResult(id);
	}
	
}
