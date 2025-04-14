package com.example.todo_app_for_spring.annotation.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.todo_app_for_spring.validator.PasswordValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * パスワードバリデーションアノテーションです。<br>
 * パスワードのパターンにマッチするかを検証します。<br>
 * 指定したフィールド名をエラーメッセージに埋め込みます。
 */
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { PasswordValidator.class })
@Documented
public @interface Password {

	/**
	 * バリデーションエラー時のメッセージ
	 * 
	 * @return
	 */
	String message() default "{custom.validation.password}";

	/**
	 * バリデーショングループ
	 * 
	 * @return
	 */
	Class<?>[] groups() default {};

	/**
	 * ペイロード
	 * 
	 * @return
	 */
	Class<? extends Payload>[] payload() default {};

	/**
	 * フィールド名
	 * 
	 * @return
	 */
	String name() default "パスワード";

}
