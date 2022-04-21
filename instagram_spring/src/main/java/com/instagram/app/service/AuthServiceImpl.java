package com.instagram.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.domain.user.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean checkUsername(String username) {
		return userRepository.checkUsername(username) != 0 ? true: false;
	}
}
