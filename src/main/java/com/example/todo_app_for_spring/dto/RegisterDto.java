package com.example.todo_app_for_spring.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザ登録画面のDTOクラスです。<br>
 * ユーザ登録画面のControllerとService間でやり取りするデータを定義します。<br>
 */
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
