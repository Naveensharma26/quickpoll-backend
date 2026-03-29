package com.quickpoll.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickpoll.entity.Polls;

@Repository
public interface PollsRepo extends JpaRepository<Polls,String>{

}
