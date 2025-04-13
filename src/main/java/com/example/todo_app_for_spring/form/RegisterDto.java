package com.example.todo_app_for_spring.form;

import com.example.todo_app_for_spring.annotation.validation.Pattern;
import com.example.todo_app_for_spring.annotation.validation.Size;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {

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
	@Pattern(name = "パスワード", regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", pattern = "大小半角英数字記号を3種類以上")
	private String userPw;
}
