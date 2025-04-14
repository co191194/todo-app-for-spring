package com.example.todo_app_for_spring.service;

import com.example.todo_app_for_spring.dto.ChangePasswordDto;

/**
 * パスワード変更画面のServiceインターフェースです。<br>
 * パスワード変更画面のControllerとService間でやり取りするメソッドを定義します。<br>
 */
public interface ChangePasswordService {

	/**
	 * パスワード変更を行います。
	 * 
	 * @param changePasswordDto
	 */
	public void changePassword(ChangePasswordDto changePasswordDto);
}
