package com.quickpoll.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	String pollId;
	
	String pollName;
	String password;
	String pollQuestion;
	String createdBy;
	LocalDateTime createdAt;
	String isAnonymous;
	String isPublic;
	LocalDateTime expiresAt;
	
}
