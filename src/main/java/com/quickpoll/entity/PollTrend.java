package com.quickpoll.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PollTrend {

	String poll_id;
	String poll_question;
	String poll_name;
	Integer total_votes;
	
}
