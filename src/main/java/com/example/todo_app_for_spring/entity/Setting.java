package com.example.todo_app_for_spring.entity;

import java.time.LocalDateTime;

import com.example.todo_app_for_spring.entity.pk.SettingPK;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
@IdClass(SettingPK.class)
public class Setting {

	/**
	 * 設定グループ
	 */
	@Id
	private String settingGroup;

	/**
	 * 設定キー
	 */
	@Id
	private String settingKey;

	/**
	 * 設定値
	 */
	private String settingValue;

	/**
	 * 設定値の説明
	 */
	private String settingDescription;

	/**
	 * バージョン
	 */
	@Version
	private Integer version = 0;

	/**
	 * 作成者
	 */
	private String createdBy;

	/**
	 * 作成日時
	 */
	private LocalDateTime createdAt;

	/**
	 * 更新者
	 */
	private String updatedBy;

	/**
	 * 更新日時
	 */
	private LocalDateTime updatedAt;

}
