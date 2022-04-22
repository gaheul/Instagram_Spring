package com.instagram.app.auth;

import com.instagram.app.domain.user.User;

public interface PrincipalService {
	public User loadUserByUsername(String username);
	public boolean passwordCheck(String password , User user); 
}
