package com.example.todo_app_for_spring.service;

import java.util.List;

import com.example.todo_app_for_spring.dto.TodoDto;
import com.example.todo_app_for_spring.entity.Todo;

/**
 * ToDo画面のサービスインターフェース
 */
public interface TodoService {

	/**
	 * ユーザIDからToDo情報を取得する
	 * 
	 * @param userId
	 * @return
	 */
	public List<Todo> getToDoList();

	/**
	 * ToDo情報を登録する
	 * 
	 * @param userId
	 * @param todoDate
	 * @param todoTitle
	 * @param todoContent
	 */
	public void insertToDo(TodoDto todoDto);

	/**
	 * ToDo情報を削除する
	 * 
	 * @param todoId
	 */
	public void deleteToDo(Long todoId);
	
	/**
	 * ToDo情報を更新する
	 * 
	 * @param todoId
	 * @param todoTitle
	 * @param todoContent
	 */
	public void updateToDo(TodoDto todoDto);
}
