package com.security.configuration;

import org.springframework.security.core.userdetails.UserDetails;

import com.security.entities.User;

public class CustomUserSecurity extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4336989559986903388L;

	public CustomUserSecurity() {}

	public CustomUserSecurity(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
