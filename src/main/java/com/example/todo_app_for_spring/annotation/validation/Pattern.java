package com.example.todo_app_for_spring.annotation.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.todo_app_for_spring.validator.PatternValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PatternValidator.class})
@Documented
public @interface Pattern {

	/**
	 * バリデーションエラー時のメッセージ
	 * 
	 * @return
	 */
	String message() default "{custom.validation.pattern}";

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
	 * 正規表現
	 * 
	 * @return
	 */
	String regexp();
	
	/**
	 * フィールド名
	 */
	String name();
	
	/**
	 * パターン
	 * 
	 * @return
	 */
	String pattern();
}
