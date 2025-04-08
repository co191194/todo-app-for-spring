package com.example.todo_app_for_spring.service;

/**
 * ログイン画面のサービスのインターフェースです。
 */
public interface LoginService {

	/**
	 * ログイン処理を行います。
	 * 
	 * @param userId
	 * @param userPw
	 */
	void login(String userId, String userPw);
}
