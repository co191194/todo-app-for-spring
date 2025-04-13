package com.example.todo_app_for_spring.service;

import com.example.todo_app_for_spring.form.RegisterDto;

public interface RegisterService {

	/**
	 * ユーザ登録を行います。
	 * 
	 * @param registerForm
	 * @return
	 */
	public void register(RegisterDto registerDto);
}
