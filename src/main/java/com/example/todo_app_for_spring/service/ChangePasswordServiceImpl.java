package com.example.todo_app_for_spring.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todo_app_for_spring.dto.ChangePasswordDto;
import com.example.todo_app_for_spring.entity.Account;
import com.example.todo_app_for_spring.repository.AccountRepository;
import com.example.todo_app_for_spring.utility.LoginUserUtility;

import lombok.RequiredArgsConstructor;

/**
 * パスワード変更画面のService実装クラスです。<br>
 * パスワード変更画面のビジネスロジックを実装します。<br>
 */
@Service
@RequiredArgsConstructor
public class ChangePasswordServiceImpl implements ChangePasswordService {
	/**
	 * アカウントのリポジトリ
	 */
	private final AccountRepository accountRepository;
	
	/**
	 * パスワードエンコーダ
	 */
	private final PasswordEncoder passwordEncoder;

	@Override
	public void changePassword(ChangePasswordDto changePasswordDto) {

		// パスワードをエンコード
		String password = passwordEncoder.encode(changePasswordDto.getNewPassword());
		
		// ログインユーザ情報を取得
		Account account = accountRepository.findByUserId(LoginUserUtility.getLoginUserId());
		
		// パスワードを変更
		account.setUserPw(password);
		
		// 更新する
		accountRepository.save(account);

	}

}
