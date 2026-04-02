package com.quickpoll.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PollVoteResult {
	String pollId;
	String pollName;
	String createdBy;
	String pollQuestion;
	String pollOptionName;
	int voteCount;
	
	
}
