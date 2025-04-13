package com.example.todo_app_for_spring.validator;

import org.apache.commons.lang3.StringUtils;

import com.example.todo_app_for_spring.annotation.validation.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 正規表現バリデーションの実装クラスです。<br>
 * 指定した正規表現にマッチするかを検証します。<br>
 * 指定したフィールド名とパターンをエラーメッセージに埋め込みます。<br>
 */
public class PatternValidator implements ConstraintValidator<Pattern, String> {

	/**
	 * 正規表現
	 */
	String regexp;
	/**
	 * フィールド名
	 */
	String name;
	/**
	 * パターン
	 */
	String pattern;

	@Override
	public void initialize(Pattern constraintAnnotation) {
		this.regexp = constraintAnnotation.regexp();
		this.name = constraintAnnotation.name();
		this.pattern = constraintAnnotation.pattern();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// nullと空文字は＠NotEmptyでチェックするので、ここではチェックしない
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		return value.matches(regexp);
	}

}
