package com.example.todo_app_for_spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.todo_app_for_spring.constant.MessageId;
import com.example.todo_app_for_spring.form.RegisterForm;
import com.example.todo_app_for_spring.repository.AccountRepository;
import com.example.todo_app_for_spring.utility.MessageUtility;

import lombok.RequiredArgsConstructor;

/**
 * ユーザ登録画面のバリデーションクラスです。
 */
@Component
@RequiredArgsConstructor
public class RegisterValidator implements Validator {

	private final AccountRepository accountRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// Formのキャスト
		RegisterForm registerForm = RegisterForm.class.cast(target);

		// ユーザIDの重複チェック
		validateDuplicateUserId(registerForm, errors);

	}

	/**
	 * ユーザIDの重複チェックを行います。
	 * 
	 * @param registerForm
	 * @param errors
	 */
	private void validateDuplicateUserId(RegisterForm registerForm, Errors errors) {

		// ユーザIDの重複チェック
		if (accountRepository.existsByUserId(registerForm.getUserId())) {
			errors.rejectValue("userId", MessageId.M0001E, new Object[] { registerForm.getUserId() },
					MessageUtility.getMessage(MessageId.M0001E, "ユーザID"));
		}
	}

}
