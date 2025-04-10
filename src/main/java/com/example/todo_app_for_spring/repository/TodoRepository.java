package com.example.todo_app_for_spring.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_app_for_spring.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	/**
	 * ユーザIDからToDo情報を取得する
	 * 
	 * @param userId
	 * @return
	 */
	List<Todo> findByUserId(String userId, Sort sort);
}
