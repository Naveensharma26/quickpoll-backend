package com.quickpoll.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PollRequest {
	String pollId;
	String pollName;
	String password;
	String pollQuestion;
	String createdBy;
	LocalDateTime createdAt;
	String isAnonymous;
	String isPublic;
	Long duration;
}
