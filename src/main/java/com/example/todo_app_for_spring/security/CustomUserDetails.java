package com.example.todo_app_for_spring.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.todo_app_for_spring.entity.Account;

import lombok.Data;

@Data
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = -2040529305275897507L;

	private final Account user;
	private static final List<GrantedAuthority> ROLE_USER = Collections
			.unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER"));

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return ROLE_USER;
	}

	@Override
	public String getPassword() {
		return user.getUserPw();
	}

	@Override
	public String getUsername() {
		return user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.getIsLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
