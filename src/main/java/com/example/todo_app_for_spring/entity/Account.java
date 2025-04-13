package com.example.todo_app_for_spring.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

/**
 * アカウントテーブルのエンティティクラスです。<br>
 * アカウントテーブルのカラムを定義します。<br>
 */
@Data
@Entity(name = "account")
public class Account {

	// ユーザID
	@Id
	private String userId;
	// ユーザパスワード
	private String userPw;
	// ユーザ名
	private String userName;
	// ユーザロック判定
	private Boolean isLocked = false;
	// ログイン試行回数
	private Integer countTry = 0;
	// バージョン
	@Version
	private Integer version = 1;
	// 作成者
	private String createdBy;
	// 作成日時
	private LocalDateTime createdAt;
	// 更新者
	private String updatedBy;
	// 更新日時
	private LocalDateTime updatedAt;

}
