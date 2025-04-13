package com.example.todo_app_for_spring.annotation.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.todo_app_for_spring.validator.SizeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { SizeValidator.class })
@Documented
public @interface Size {

	/**
	 * バリデーションエラー時のメッセージ
	 * 
	 * @return
	 */
	String message() default "{custom.validation.size}";

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
	 * 最小値
	 * 
	 * @return
	 */
	int min() default 0;

	/**
	 * 最大値
	 * 
	 * @return
	 */
	int max();

	/**
	 * フィールド名
	 */
	String name();

}
