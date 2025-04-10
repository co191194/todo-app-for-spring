package com.example.todo_app_for_spring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.todo_app_for_spring.dto.TodoDto;
import com.example.todo_app_for_spring.entity.Todo;
import com.example.todo_app_for_spring.repository.TodoRepository;
import com.example.todo_app_for_spring.utility.LoginUserUtility;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	/**
	 * モデルマッパー
	 */
	private final ModelMapper modelMapper;

	/**
	 * ToDoリポジトリ
	 */
	private final TodoRepository todoRepository;

	@Override
	public List<Todo> getToDoList() {
		return todoRepository.findByUserId(LoginUserUtility.getLoginUserId(),
				Sort.by("todoDate").ascending().and(Sort.by("todoId").ascending()));
	}

	@Override
	public void insertToDo(TodoDto todoDto) {

		// ユーザIDを取得
		String userId = LoginUserUtility.getLoginUserId();
		// テーブルデータ作成
		Todo todo = modelMapper.map(todoDto, Todo.class);
		todo.setUserId(userId);
		todo.setCreatedBy(userId);
		todo.setCreatedAt(LocalDateTime.now());
		// 登録
		todoRepository.save(todo);
	}

	@Override
	public void deleteToDo(Long todoId) {
		// テーブルデータを取得する
		Todo todo = todoRepository.findById(Long.valueOf(todoId)).orElse(null);
		if (todo != null) {
			// 削除
			todoRepository.delete(todo);
		} else {
			System.out.println("データが見つかりませんでした。 ID: " + todoId);
		}
	}

	@Override
	public void updateToDo(TodoDto todoDto) {
		// 最新のテーブル情報を取得する
		Todo todo = todoRepository.findById(Long.valueOf(todoDto.getTodoId())).orElse(null);
		// 上書き
		modelMapper.map(todoDto, todo);
		// 更新
		todoRepository.save(todo);
	}

}
