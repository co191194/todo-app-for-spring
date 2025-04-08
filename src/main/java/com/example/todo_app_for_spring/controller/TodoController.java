package com.example.todo_app_for_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo_app_for_spring.form.TodoForm;
import com.example.todo_app_for_spring.service.TodoService;
import com.example.todo_app_for_spring.utility.LoginUserUtility;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

	private final TodoService todoService;

	@GetMapping
	public String init(Model model) {
		model.addAttribute("todoList", todoService.getToDoList(LoginUserUtility.getLoginUserId()));
		return "todo";
	}

	@PostMapping("/insert")
	public String insert(@ModelAttribute TodoForm todoForm) {
		todoService.insertToDo(LoginUserUtility.getLoginUserId(), todoForm.getTodoDate(), todoForm.getTodoTitle(),
				todoForm.getTodoContent());
		return "redirect:/todo";
	}
	
	@GetMapping("/delete/{todoId}")
	public String delete(@PathVariable("todoId") Long todoId) {
		todoService.deleteToDo(todoId);
		return "redirect:/todo";
	}

}
