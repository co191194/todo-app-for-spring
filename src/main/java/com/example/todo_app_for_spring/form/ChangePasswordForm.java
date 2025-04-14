package com.example.todo_app_for_spring.form;

import com.example.todo_app_for_spring.annotation.validation.Password;
import com.example.todo_app_for_spring.annotation.validation.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * パスワード変更画面のFormクラスです。<br>
 * パスワード変更画面のControllerとView間でやり取りするデータを定義します。<br>
 */
@Getter
@Setter
public class ChangePasswordForm {

	// 現在のパスワード
	@Size(name = "現在のパスワード", min = 8, max = 32)
	private String currentPassword;
	// 新しいパスワード
	@Size(name = "新しいパスワード", min = 8, max = 32)
	@Password(name = "新しいパスワード")
	private String newPassword;
	// 新しいパスワード（確認用）
	@Size(name = "新しいパスワード（確認用）", min = 8, max = 32)
	@Password(name = "新しいパスワード（確認用）")
	private String newPasswordConfirm;

}
