package com.example.todo_app_for_spring.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.todo_app_for_spring.entity.Account;
import com.example.todo_app_for_spring.repository.AccountRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account user = accountRepository.findByUserId(username);
		if (user == null) {
			throw new UsernameNotFoundException("次のユーザが見つかりません。 userId: " + username);
		}
		
		return new CustomUserDetails(user);
	}

}
