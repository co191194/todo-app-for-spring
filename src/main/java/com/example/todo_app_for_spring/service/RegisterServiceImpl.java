package com.example.todo_app_for_spring.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todo_app_for_spring.dto.RegisterDto;
import com.example.todo_app_for_spring.entity.Account;
import com.example.todo_app_for_spring.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

/**
 * ユーザ登録画面のサービスクラスです。<br>
 * ユーザ登録画面のビジネスロジックを実装します。<br>
 */
@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

	/**
	 * モデルマッパー
	 */
	private final ModelMapper modelMapper;
	
	/**
	 * パスワードエンコーダ
	 */
	private final PasswordEncoder passwordEncoder;

	/**
	 * アカウントのリポジトリ
	 */
	private final AccountRepository accountRepository;

	@Override
	public void register(RegisterDto registerDto) {
		// ユーザ登録情報をエンティティに変換
		Account account = modelMapper.map(registerDto, Account.class);
		
		// パスワードをエンコード
		account.setUserPw(passwordEncoder.encode(registerDto.getUserPw()));
		
		// 登録者などを設定
		account.setCreatedBy(registerDto.getUserId());
		account.setCreatedAt(LocalDateTime.now());
		
		// ユーザ登録
		accountRepository.save(account);
		
	}

}
