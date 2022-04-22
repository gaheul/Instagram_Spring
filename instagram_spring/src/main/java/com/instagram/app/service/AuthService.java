package com.instagram.app.service;

import com.instagram.app.web.dto.auth.SignupRequestDto;

public interface AuthService {
	public boolean checkUsername(String username);
	public boolean signup(SignupRequestDto signupRequestDto);
	
}
