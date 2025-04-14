package com.example.todo_app_for_spring.utility;

import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.todo_app_for_spring.entity.Account;
import com.example.todo_app_for_spring.security.CustomUserDetails;

/**
 * ログインユーザの情報を取得するユーティリティクラスです。<br>
 */
public class LoginUserUtility {

	/**
	 * ログインユーザの情報を取得します。
	 * 
	 * @return
	 */
	public static Account getLoginUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof CustomUserDetails userDetails) {
				return userDetails.getUser();
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * ログインユーザのIDを取得します。
	 * 
	 * @return
	 */
	public static String getLoginUserId() {
		Account user = getLoginUser();
		if (Objects.nonNull(user)) {
			return user.getUserId();
		}
		return null;
	}

	/**
	 * ログインユーザの名前を取得します。
	 * 
	 * @return
	 */
	public static String getLoginUserName() {
		Account user = getLoginUser();
		if (Objects.nonNull(user)) {
			return user.getUserName();
		}
		return null;
	}
	
	
}
