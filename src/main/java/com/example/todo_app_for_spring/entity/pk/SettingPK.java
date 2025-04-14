package com.example.todo_app_for_spring.entity.pk;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SettingPK implements Serializable {

	private static final long serialVersionUID = 6617286447851318056L;
	
	/**
	 * 設定グループ
	 */
	private String settingGroup;
	/**
	 * 設定キー
	 */
	private String settingKey;

}
