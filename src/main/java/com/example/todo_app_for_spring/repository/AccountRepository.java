package com.example.todo_app_for_spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.todo_app_for_spring.entity.Account;

public interface AccountRepository extends CrudRepository<Account, String> {

	/**
	 * ユーザIDからユーザ情報を取得する
	 * 
	 * @param userId
	 * @return
	 */
	Account findByUserId(String userId);
}
