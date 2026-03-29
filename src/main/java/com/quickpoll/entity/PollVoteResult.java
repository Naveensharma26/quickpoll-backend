package com.quickpoll.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PollVoteResult {
	String poll_id;
	String poll_name;
	String created_by;
	String poll_question;
	String poll_option_name;
	int vote_count;
	
	
}
