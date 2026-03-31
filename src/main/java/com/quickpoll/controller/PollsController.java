package com.quickpoll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickpoll.entity.Polls;
import com.quickpoll.entity.PollsResponse;
import com.quickpoll.repo.PollTrend;
import com.quickpoll.repo.PollsRepo;
import com.quickpoll.service.PollsService;

@RestController
@CrossOrigin(origins = "*")
public class PollsController {
	
	@Autowired
	PollsService service;
	
	@GetMapping("/ping")
	public String ping() {
	    return "OK";
	}
	
	@PostMapping("/addPoll")
	public Polls addPoll(@RequestBody Polls p){
		return service.addPoll(p);
	}
	
	@GetMapping("/getPollById/{id}")
	public PollsResponse getPollById(@PathVariable String id) {
		return service.getPollById(id);
	}	
	
	@PostMapping("/verifyUser")
	public boolean verifyUser(@RequestBody Polls p) {
		return service.verifyUser(p.getPoll_id(), p.getPassword());
	}
	
	@GetMapping("/getTrendingPolls")
	public List<PollTrend> getTrendingPolls(){
		return service.getTrendingPolls();
	}
	
}
