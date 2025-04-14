package com.example.todo_app_for_spring.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo_app_for_spring.dto.TodoDto;
import com.example.todo_app_for_spring.form.TodoForm;
import com.example.todo_app_for_spring.service.TodoService;
import com.example.todo_app_for_spring.utility.LoginUserUtility;
import com.example.todo_app_for_spring.validator.TodoValidator;

import lombok.RequiredArgsConstructor;

/**
 * ToDo画面のコントローラーです。<br>
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

	/**
	 * ToDo画面のToDoIDを示すURLパス変数名
	 */
	private static final String TODO_ID = "todoId";

	/**
	 * モデルマッパー
	 */
	private final ModelMapper modelMapper;

	/**
	 * ToDoサービス
	 */
	private final TodoService todoService;

	/**
	 * ToDo画面のバリデーションクラス
	 */
	private final TodoValidator todoValidator;

	/**
	 * バリデータの追加
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// ToDo画面のバリデーターを追加
		binder.addValidators(todoValidator);
	}

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
		model.addAttribute("userName", LoginUserUtility.getLoginUserName());
		model.addAttribute("errorMessage", null);
		return "todo";
	}

	/**
	 * ToDo情報登録
	 * 
	 * @param todoForm
	 * @return
	 */
	@PostMapping("/insert")
	public String insert(Model model, @ModelAttribute @Validated TodoForm todoForm, BindingResult br) {
		if (br.hasErrors()) {
			List<TodoForm> todoList = modelMapper.map(todoService.getToDoList(), new TypeToken<List<TodoForm>>() {
			}.getType());
			model.addAttribute("todoList", todoList);
			model.addAttribute("userName", LoginUserUtility.getLoginUserName());
			model.addAttribute("errorMessage", br.getAllErrors().get(0).getDefaultMessage());
			return "todo";
		}
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
	public String delete(@PathVariable(TODO_ID) Long todoId) {
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
