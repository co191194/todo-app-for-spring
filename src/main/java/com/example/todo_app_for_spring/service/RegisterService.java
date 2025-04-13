package com.example.todo_app_for_spring.service;

import com.example.todo_app_for_spring.dto.RegisterDto;

/**
 * ユーザ登録画面のServiceインターフェースです。<br>
 * ユーザ登録画面のControllerとService間でやり取りするメソッドを定義します。<br>
 */
public interface RegisterService {

	/**
	 * ユーザ登録を行います。
	 * 
	 * @param registerForm
	 * @return
	 */
	public void register(RegisterDto registerDto);
}
