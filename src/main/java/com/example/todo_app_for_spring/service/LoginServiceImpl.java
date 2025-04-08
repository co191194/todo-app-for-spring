package com.example.todo_app_for_spring.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
	
	private final AuthenticationManager authenticationManager;

	@Override
	public void login(String userId, String userPw) {

		Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(userId, userPw);
		
		// 認証を実行
		Authentication auth = authenticationManager.authenticate(authentication);
		// TODO: 認証結果をセッションに保存
		
		return;
	}

}
