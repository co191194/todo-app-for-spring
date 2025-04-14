package com.example.todo_app_for_spring.validator;

import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.todo_app_for_spring.constant.MessageId;
import com.example.todo_app_for_spring.form.ChangePasswordForm;
import com.example.todo_app_for_spring.repository.AccountRepository;
import com.example.todo_app_for_spring.utility.LoginUserUtility;
import com.example.todo_app_for_spring.utility.MessageUtility;

import lombok.RequiredArgsConstructor;

/**
 * パスワード変更画面のバリデーションクラスです。
 */
@Component
@RequiredArgsConstructor
public class ChangePasswordValidator implements Validator {

	/**
	 * アカウントのリポジトリ
	 */
	private final AccountRepository accountRepository;

	/**
	 * パスワードエンコーダ
	 */
	private final PasswordEncoder passwordEncoder;

	@Override
	public boolean supports(Class<?> clazz) {
		return ChangePasswordForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Formのキャスト
		ChangePasswordForm changePasswordForm = ChangePasswordForm.class.cast(target);

		// 現在のパスワードのチェック
		validateCurrentPassword(changePasswordForm, errors);

		// 新しいパスワードのチェック
		validateNewPassword(changePasswordForm, errors);

	}

	/**
	 * 現在のパスワードのチェックを行います。
	 * 
	 * @param changePasswordForm
	 * @param errors
	 */
	private void validateCurrentPassword(ChangePasswordForm changePasswordForm, Errors errors) {
		// 現在のパスワードが一致するかチェック
		if (!passwordEncoder.matches(changePasswordForm.getCurrentPassword(),
				accountRepository.findByUserId(LoginUserUtility.getLoginUserId()).getUserPw())) {
			errors.rejectValue("currentPassword", MessageId.M0002E, MessageUtility.getMessage(MessageId.M0002E, "現在のパスワード"));
		}
	}

	/**
	 * 新しいパスワードのチェックを行います。
	 * 
	 * @param changePasswordForm
	 * @param errors
	 */
	private void validateNewPassword(ChangePasswordForm changePasswordForm, Errors errors) {
		// 新しいパスワードと確認用パスワードが一致するかチェック
		if (!Objects.equals(changePasswordForm.getNewPassword(), changePasswordForm.getNewPasswordConfirm())) {
			errors.rejectValue("newPasswordConfirm", MessageId.M0003E, MessageUtility.getMessage(MessageId.M0003E, "新しいパスワード", "確認用パスワード"));
		}
	}

}
