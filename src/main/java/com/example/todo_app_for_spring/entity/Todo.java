package com.example.todo_app_for_spring.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

/**
 * ToDoテーブルのエンティティクラスです。<br>
 * ToDoテーブルのカラムを定義します。<br>
 */
@Data
@Entity(name = "todo")
public class Todo {

	// ToDoID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long todoId;
	// ユーザID
	private String userId;
	// ToDo日付
	private LocalDate todoDate;
	// ToDoタイトル
	private String todoTitle;
	// ToDo内容
	private String todoContent;
	// 完了フラグ
	private Boolean isComplete = false;
	// バージョン
	@Version
	private Integer version = 0;
	// 作成者
	private String createdBy;
	// 作成日時
	private LocalDateTime createdAt;
	// 更新者
	private String updatedBy;
	// 更新日時
	private LocalDateTime updatedAt;
}
