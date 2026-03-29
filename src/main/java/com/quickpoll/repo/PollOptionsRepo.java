package com.quickpoll.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quickpoll.entity.PollOptions;

@Repository
public interface PollOptionsRepo extends JpaRepository<PollOptions,Integer>{

	public List<PollOptions> findAllByPollId(String pollId);
	
}
