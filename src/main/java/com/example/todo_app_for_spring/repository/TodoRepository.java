package com.example.todo_app_for_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_app_for_spring.entity.Todo;

/**
 * ToDo情報のリポジトリインターフェースです。<br>
 * ToDoテーブルのCRUD操作を行います。<br>
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {

	/**
	 * ユーザIDからToDo情報を取得する
	 * 
	 * @param userId
	 * @return
	 */
	List<Todo> findByUserIdOrderByTodoDateAscTodoIdAsc(String userId);
	
	/**
	 * ユーザIDからToDo件数を取得する
	 * 
	 * @param userId
	 * @return
	 */
	int countByUserId(String userId);
}
