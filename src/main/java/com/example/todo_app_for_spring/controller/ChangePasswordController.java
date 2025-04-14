package com.example.todo_app_for_spring.controller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo_app_for_spring.dto.ChangePasswordDto;
import com.example.todo_app_for_spring.form.ChangePasswordForm;
import com.example.todo_app_for_spring.service.ChangePasswordService;
import com.example.todo_app_for_spring.validator.ChangePasswordValidator;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/change-password")
public class ChangePasswordController {

    private final ModelMapper modelMapper;
	
	/**
	 * パスワード変更画面のバリデーションクラス
	 */
	private final ChangePasswordValidator changePasswordValidator;
	
	/**
	 * パスワード変更画面のサービスクラス
	 */
	private final ChangePasswordService changePasswordService;

	/**
	 * バリデータの追加
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(changePasswordValidator);
	}
	
	/**
	 * パスワード変更画面初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String init(Model model) {
		model.addAttribute("errorMessage", null);
		model.addAttribute("changePasswordForm", new ChangePasswordForm());
		model.addAttribute("isCompleted", false);
		return "change-password";
	}

	/**
	 * パスワード変更処理
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping
	public String changePassword(Model model, @ModelAttribute @Validated ChangePasswordForm changePasswordForm,
			BindingResult br) {
		if (br.hasErrors()) {
			model.addAttribute("errorMessage", br.getAllErrors().get(0).getDefaultMessage());
			model.addAttribute("changePasswordForm", changePasswordForm);
			model.addAttribute("isCompleted", false);
			return "change-password";
		}
		changePasswordService.changePassword(modelMapper.map(changePasswordForm, ChangePasswordDto.class));
		model.addAttribute("isCompleted", true);
		return "change-password";
	}
}
