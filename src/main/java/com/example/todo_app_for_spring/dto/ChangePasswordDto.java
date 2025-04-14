package com.example.todo_app_for_spring.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * パスワード変更画面のDTOクラスです。<br>
 * パスワード変更画面のControllerとService間でやり取りするデータを定義します。<br>
 */
@Getter
@Setter
public class ChangePasswordDto {

	/**
	 * 現在のパスワード
	 */
	private String currentPassword;

	/**
	 * 新しいパスワード
	 */
	private String newPassword;

	/**
	 * 新しいパスワード（確認用）
	 */
	private String newPasswordConfirm;
}
