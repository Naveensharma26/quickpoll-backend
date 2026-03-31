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

	String poll_id;	
	String poll_name;
	String poll_question;
	String created_by;
	String created_at;
	String is_anonymous;
	
}
