package com.example.todo_app_for_spring.service;

import java.time.LocalDate;
import java.util.List;

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
	public List<Todo> getToDoList(String userId);

	/**
	 * ToDo情報を登録する
	 * 
	 * @param userId
	 * @param todoDate
	 * @param todoTitle
	 * @param todoContent
	 */
	public void insertToDo(String userId, LocalDate todoDate, String todoTitle, String todoContent);

	/**
	 * ToDo情報を削除する
	 * 
	 * @param todoId
	 */
	public void deleteToDo(Long todoId);
}
