package com.example.todo_app_for_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面のコントローラークラスです。<br>
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public String init() {
		return "login";
	}
	
}
