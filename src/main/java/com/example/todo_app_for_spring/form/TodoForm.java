package com.example.todo_app_for_spring.form;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoForm {

	private Long todoId;
	private LocalDate todoDate;
	private String todoTitle;
	private String todoContent;
	private Integer version;
	
}
