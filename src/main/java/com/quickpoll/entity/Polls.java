package com.quickpoll.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Polls {

	@Id
	String poll_id;
	
	String poll_name;
	String password;
	String poll_question;
	String created_by;
	String created_at;
	String is_anonymous;
	
}
