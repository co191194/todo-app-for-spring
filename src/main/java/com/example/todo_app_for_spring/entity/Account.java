package com.example.todo_app_for_spring.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "account")
public class Account {

	@Id
	private String userId;
	private String userPw;
	private String userName;
	private Boolean isLocked;
	private Integer countTry;
	@Version
	private Integer version;
	private String createdBy;
	private LocalDateTime createdAt;
	private String updatedBy;
	private LocalDateTime updatedAt;

}
