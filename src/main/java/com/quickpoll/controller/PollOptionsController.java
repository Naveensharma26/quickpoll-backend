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

import com.quickpoll.entity.PollOptions;
import com.quickpoll.service.PollOptionsService;

@RestController
@CrossOrigin
public class PollOptionsController {
	
	@Autowired
	PollOptionsService service;
	
	@PostMapping("/addOptions")
	public List<PollOptions> addOptions(@RequestBody List<PollOptions> list) {
		return service.addOptions(list);
	} 
	
	@GetMapping("/getOptions/{id}")
	public List<PollOptions> getOptionsByPoll(@PathVariable String id) {
		return service.getOptionsByPollId(id);
	}
	
	@PutMapping("/updateCount")
	public PollOptions updateCount(@RequestBody PollOptions poll) {
		return service.updateCount(poll);
	}
	
}
