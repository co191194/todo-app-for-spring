package com.example.todo_app_for_spring.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.todo_app_for_spring.security.CustomUserDetails;

public class LoginUserUtility {

	/**
	 * ログインユーザのIDを取得します。
	 * 
	 * @return
	 */
	public static String getLoginUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof CustomUserDetails userDetails) {
				return userDetails.getUsername();
			} else {
				return principal.toString();
			}
		}
		return null;
	}
}
