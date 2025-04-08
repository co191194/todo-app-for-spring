package com.example.todo_app_for_spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.todo_app_for_spring.entity.User;

public interface UserRepository extends CrudRepository<User, String> {

	/**
	 * ユーザIDからユーザ情報を取得する
	 * 
	 * @param userId
	 * @return
	 */
	User findByUserId(String userId);
}
