package com.example.todo_app_for_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_app_for_spring.entity.Setting;
import com.example.todo_app_for_spring.entity.pk.SettingPK;

public interface SettingRepository extends JpaRepository<Setting, SettingPK> {

}
