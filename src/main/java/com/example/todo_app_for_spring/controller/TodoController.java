package com.example.todo_app_for_spring.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo_app_for_spring.dto.TodoDto;
import com.example.todo_app_for_spring.form.TodoForm;
import com.example.todo_app_for_spring.service.TodoService;

import lombok.RequiredArgsConstructor;

/**
 * ToDo画面のコントローラーです。
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

	/**
	 * モデルマッパー
	 */
	private final ModelMapper modelMapper;

	/**
	 * ToDoサービス
	 */
	private final TodoService todoService;

	/**
	 * ToDo画面初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String init(Model model) {
		List<TodoForm> todoList = modelMapper.map(todoService.getToDoList(), new TypeToken<List<TodoForm>>() {
		}.getType());
		model.addAttribute("todoList", todoList);
		return "todo";
	}

	/**
	 * ToDo情報登録
	 * 
	 * @param todoForm
	 * @return
	 */
	@PostMapping("/insert")
	public String insert(@ModelAttribute TodoForm todoForm) {
		TodoDto todoDto = modelMapper.map(todoForm, TodoDto.class);
		todoService.insertToDo(todoDto);
		return "redirect:/todo";
	}

	/**
	 * ToDo情報削除
	 * 
	 * @param todoId
	 * @return
	 */
	@GetMapping("/delete/{todoId}")
	public String delete(@PathVariable("todoId") Long todoId) {
		todoService.deleteToDo(todoId);
		return "redirect:/todo";
	}

	/**
	 * ToDo情報更新
	 * 
	 * @param todoForm
	 * @return
	 */
	@PostMapping("/update")
	public String update(@RequestBody TodoForm todoForm) {
		TodoDto todoDto = modelMapper.map(todoForm, TodoDto.class);
		todoService.updateToDo(todoDto);
		return "redirect:/todo";
	}

}
