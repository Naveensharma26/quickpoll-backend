package com.quickpoll.repo;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.quickpoll.entity.Polls;

@Repository
public interface PollsRepo extends JpaRepository<Polls,String>{
	
	@Query(value = "SELECT p.poll_id, p.poll_question, SUM(po.vote_count) as total_votes,p.poll_name,p.created_by FROM polls p " +
            "INNER JOIN poll_options po ON p.poll_id = po.poll_id " +
            "WHERE p.is_public = 'Y' "+
            "GROUP BY p.poll_id " +
            "ORDER BY SUM(po.vote_count) DESC " +
            "LIMIT 5", nativeQuery = true)
    List<PollTrend> findTopPublicPolls();
	
	Polls findByPollId(String pollId);

}
