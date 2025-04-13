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

import com.example.todo_app_for_spring.dto.RegisterDto;
import com.example.todo_app_for_spring.form.RegisterForm;
import com.example.todo_app_for_spring.service.RegisterService;
import com.example.todo_app_for_spring.validator.RegisterValidator;

import lombok.RequiredArgsConstructor;

/**
 * ユーザ登録画面のコントローラークラスです。<br>
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {

	/**
	 * ユーザ登録画面のバリデーションクラス
	 */
	private final RegisterValidator registerValidator;

	/**
	 * ユーザ登録画面のサービスクラス
	 */
	private final RegisterService registerService;
	
	/**
	 * モデルマッパー
	 */
	 private final ModelMapper modelMapper;

	/**
	 * バリデータの追加
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(registerValidator);
	}

	/**
	 * 登録画面初期表示
	 * 
	 * @return
	 */
	@GetMapping
	public String init(Model model) {
		model.addAttribute("errorMessage", null);
		model.addAttribute("registerForm", new RegisterForm());
		return "register";
	}

	@PostMapping
	public String register(Model model, @ModelAttribute @Validated RegisterForm registerForm, BindingResult br) {
		if (br.hasErrors()) {
			model.addAttribute("errorMessage", br.getAllErrors().get(0).getDefaultMessage());
			model.addAttribute("registerForm", registerForm);
			return "register";
		}
		// 変換
		RegisterDto registerDto = modelMapper.map(registerForm, RegisterDto.class);
		// サービスクラスを呼び出してユーザ登録を行う
		registerService.register(registerDto);
		return "redirect:/login";
	}

}
