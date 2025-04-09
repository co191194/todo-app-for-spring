package com.example.todo_app_for_spring.security;

import org.springframework.security.core.session.ReactiveSessionInformation;
import org.springframework.security.core.session.ReactiveSessionRegistry;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TodoSessionRegistory implements ReactiveSessionRegistry {

	@Override
	public Flux<ReactiveSessionInformation> getAllSessions(Object principal) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Mono<Void> saveSessionInformation(ReactiveSessionInformation information) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Mono<ReactiveSessionInformation> getSessionInformation(String sessionId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Mono<ReactiveSessionInformation> removeSessionInformation(String sessionId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Mono<ReactiveSessionInformation> updateLastAccessTime(String sessionId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
