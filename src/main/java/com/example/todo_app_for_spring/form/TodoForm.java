package com.example.todo_app_for_spring.form;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * ToDo画面のFormクラスです。<br>
 * ToDo画面のControllerとView間でやり取りするデータを定義します。<br>
 */
@Getter
@Setter
public class TodoForm {

	// ToDoID
	private Long todoId;
	// ToDo日付
	private LocalDate todoDate;
	// ToDoタイトル
	private String todoTitle;
	// ToDo内容
	private String todoContent;
	// バージョン
	private Integer version;
	
}
