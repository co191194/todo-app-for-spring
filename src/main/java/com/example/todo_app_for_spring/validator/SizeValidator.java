package com.example.todo_app_for_spring.validator;

import org.apache.commons.lang3.StringUtils;

import com.example.todo_app_for_spring.annotation.validation.Size;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SizeValidator implements ConstraintValidator<Size, String> {
	
	// 最小文字数
	int min;
	// 最大文字数
	int max;
	// フィールド名
	String name;

	@Override
	public void initialize(Size constraintAnnotation) {
		this.min = constraintAnnotation.min();
		this.max = constraintAnnotation.max();
		this.name = constraintAnnotation.name();
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// nullと空文字は＠NotEmptyでチェックするので、ここではチェックしない
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		// 文字数チェック	
		return value.length() >= min && value.length() <= max;
	}

}