package com.example.todo_app_for_spring.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * ToDo画面用のDTOです。
 */
@Getter
@Setter
public class TodoDto {
	private Long todoId;
	private LocalDate todoDate;
	private String todoTitle;
	private String todoContent;
	private Integer version;
}
