package com.example.todo_app_for_spring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo_app_for_spring.entity.Todo;
import com.example.todo_app_for_spring.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoRepository toDoRepository;

	@Override
	public List<Todo> getToDoList(String userId) {
		return toDoRepository.findByUserId(userId);
	}

	@Override
	public void insertToDo(String userId, LocalDate todoDate, String todoTitle, String todoContent) {

		// テーブルデータ作成
		Todo todo = new Todo();
		todo.setUserId(userId);
		todo.setTodoDate(todoDate);
		todo.setTodoTitle(todoTitle);
		todo.setTodoContent(todoContent);
		todo.setCreatedBy(userId);
		todo.setCreatedAt(LocalDateTime.now());
		// 登録
		toDoRepository.save(todo);

		System.out.println("insertToDo");
		System.out.println("userId: " + userId);
		System.out.println("todoDate: " + todoDate);
		System.out.println("todoTitle: " + todoTitle);
		System.out.println("todoContent: " + todoContent);

		System.out.println("insertToDo end");
	}

	@Override
	public void deleteToDo(Long todoId) {
		// テーブルデータを取得する
		Todo todo = toDoRepository.findById(Long.valueOf(todoId)).orElse(null);
		if (todo != null) {
			// 削除
			toDoRepository.delete(todo);
		} else {
			System.out.println("データが見つかりませんでした。 ID: " + todoId);
		}
	}

}
