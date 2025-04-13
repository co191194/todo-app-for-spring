package com.example.todo_app_for_spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {

	/**
	 * ユーザID
	 */
	private String userId;

	/**
	 * ユーザ名
	 */
	private String userName;
	
	/**
	 * パスワード
	 */
	private String userPw;
}
