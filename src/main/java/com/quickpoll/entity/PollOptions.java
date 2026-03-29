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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PollOptions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer poll_options_id;
	
	@Column(name = "poll_id")
	String pollId;
	
	
	String poll_option_name;
	int vote_count;
	
}
