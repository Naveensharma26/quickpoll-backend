package com.quickpoll.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PollsResponse {

	String pollId;	
	String pollName;
	String pollQuestion;
	String createdBy;
	String createdAt;
	String isAnonymous;
	String isPublic;
	String expiresAt;
}
