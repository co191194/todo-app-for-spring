package com.example.todo_app_for_spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.todo_app_for_spring.constant.MessageId;
import com.example.todo_app_for_spring.entity.Setting;
import com.example.todo_app_for_spring.entity.pk.SettingPK;
import com.example.todo_app_for_spring.form.TodoForm;
import com.example.todo_app_for_spring.repository.SettingRepository;
import com.example.todo_app_for_spring.repository.TodoRepository;
import com.example.todo_app_for_spring.utility.LoginUserUtility;
import com.example.todo_app_for_spring.utility.MessageUtility;

import lombok.RequiredArgsConstructor;

/**
 * ToDo情報のバリデーションクラスです。<br>
 * ToDo情報のバリデーションを行います。<br>
 */
@Component
@RequiredArgsConstructor
public class TodoValidator implements Validator {

	/**
	 * 設定情報のリポジトリ
	 */
	private final SettingRepository settingRepository;

	/**
	 * ToDo情報のリポジトリ
	 */
	private final TodoRepository todoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return TodoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Formのキャスト
		TodoForm todoForm = TodoForm.class.cast(target);

		// ToDoの上限数のバリデーション
		validateTodoLimit(todoForm, errors);
	}

	private void validateTodoLimit(TodoForm todoForm, Errors errors) {

		SettingPK settingPK = new SettingPK();
		settingPK.setSettingGroup("todo");
		settingPK.setSettingKey("limit");
		// ToDoの上限数を取得
		Setting setting = settingRepository.findById(settingPK).orElse(null);
		if (setting == null) {
			// 設定情報が存在しない場合はエラー
			errors.rejectValue("todoList", "error.todo.limit", new Object[] { 0 }, "ToDoの上限数が設定されていません。");
			return;
		}
		int todoLimit = Integer.parseInt(setting.getSettingValue());

		int todoCount = todoRepository.countByUserId(LoginUserUtility.getLoginUserId());

		// ToDoの上限数を超えている場合はエラー
		if (todoCount >= todoLimit) {
			errors.rejectValue(null, MessageId.M0004E, MessageUtility.getMessage(MessageId.M0004E, "ToDo", todoLimit));
		}
	}

}
