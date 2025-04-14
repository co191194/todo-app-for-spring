package com.example.todo_app_for_spring.form;

import com.example.todo_app_for_spring.annotation.validation.Password;
import com.example.todo_app_for_spring.annotation.validation.Size;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


/**
 * ユーザ登録画面のFormクラスです。<br>
 * ユーザ登録画面のControllerとView間でやり取りするデータを定義します。<br>
 */
@Getter
@Setter
public class RegisterForm {

	// ユーザID
	@NotEmpty(message = "ユーザIDは必須です")
	@Size(name="ユーザID", min = 5, max = 20)
	private String userId;
	// ユーザ名
	@NotEmpty(message = "ユーザ名は必須です")
	@Size(name = "ユーザ名", min = 1, max = 20)
	private String userName;
	// パスワード
	@NotEmpty(message = "パスワードは必須です")
	@Size(name = "パスワード", min = 8, max = 32)
	@Password
	private String userPw;
}
