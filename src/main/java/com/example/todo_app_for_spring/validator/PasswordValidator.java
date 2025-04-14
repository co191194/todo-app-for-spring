package com.example.todo_app_for_spring.validator;

import org.apache.commons.lang3.StringUtils;

import com.example.todo_app_for_spring.annotation.validation.Password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * パスワードバリデーションの実装クラスです。<br>
 * パスワードの要件を満たしているかを検証します。<br>
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {

	/**
	 * フィールド名
	 */
	String name;

	@Override
	public void initialize(Password constraintAnnotation) {
		this.name = constraintAnnotation.name();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// nullと空文字は＠NotEmptyでチェックするので、ここではチェックしない
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		
		// 全角文字が含まれている場合はNG
		if (isFullWidth(value)) {
			return false;
		}

		// 含まれている文字種類のカウント
		int count = 0;

		// 大文字が含まれているか
		if (isUpperCase(value)) {
			++count;
		}
		
		// 小文字が含まれているか
		if (isLowerCase(value)) {
			++count;
		}
		
		// 数字が含まれているか
		if (isDigit(value)) {
			++count;
		}
		
		// 記号が含まれているか
		if (isSymbol(value)) {
			++count;
		}

		return count >= 3;
	}
	
	/**
	 * 全角文字が含まれているか判定します。<br>
	 * 
	 * @param value
	 * @return
	 */
	private boolean isFullWidth(String value) {
		// 半角文字と全角文字のバイト数が異なるため、バイト数を比較することで判定する
		return value.length() != value.getBytes().length;
	}

	/**
	 * 大文字が含まれているか判定します。<br>
	 * 
	 * @param value
	 * @return
	 */
	private boolean isUpperCase(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (Character.isUpperCase(value.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 小文字が含まれているか判定します。<br>
	 * 
	 * @param value
	 * @return
	 */
	private boolean isLowerCase(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (Character.isLowerCase(value.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 数字が含まれているか判定します。<br>
	 * 
	 * @param value
	 * @return
	 */
	private boolean isDigit(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 記号が含まれているか判定します。<br>
	 * 
	 * @param value
	 * @return
	 */
	private boolean isSymbol(String value) {
		for (int i = 0; i < value.length(); i++) {
			// 半角英数字以外の文字が含まれている場合は記号とみなす
			if (!Character.isLetterOrDigit(value.charAt(i))) {
				return true;
			}
		}
		return false;
	}

}
