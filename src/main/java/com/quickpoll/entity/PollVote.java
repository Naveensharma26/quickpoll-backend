package com.quickpoll.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "poll_vote")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PollVote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer poll_vote_id;
	
	@Column(name = "poll_id")
	String pollId;
	
	String poll_option_name;
	int poll_option_id;
	String voted_by;
	
}
