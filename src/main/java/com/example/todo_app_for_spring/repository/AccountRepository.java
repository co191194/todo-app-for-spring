package com.example.todo_app_for_spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.todo_app_for_spring.entity.Account;

/**
 * アカウント情報のリポジトリインターフェースです。<br>
 * アカウントテーブルのCRUD操作を行います。<br>
 */
public interface AccountRepository extends CrudRepository<Account, String> {

	/**
	 * ユーザIDからユーザ情報を取得する
	 * 
	 * @param userId
	 * @return
	 */
	Account findByUserId(String userId);

	@Query("SELECT EXISTS (SELECT a FROM account a WHERE a.userId = :userId)")
	boolean existsByUserId(@Param("userId") String userId);
}
