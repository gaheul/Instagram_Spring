package com.instagram.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.auth.PrincipalService;
import com.instagram.app.domain.user.User;
import com.instagram.app.domain.user.UserRepository;
import com.instagram.app.web.dto.auth.SignupRequestDto;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PrincipalService principalService;
	
	@Override
	public boolean checkUsername(String username) {
		return userRepository.checkUsername(username) != 0 ? true: false;
	}
	
	@Override
	public boolean signup(SignupRequestDto signupRequestDto) {
		int result = userRepository.signup(signupRequestDto.toEntity()); //signupRequestDto.toEntity()->user객체
		return result != 0;
	}
	
	@Override
	public User signin(String username, String passowrd) {
		User user =principalService.loadUserByUsername(username); //username으로 찾으면 user객체 생성 
		if(user != null) {//null이 아닌경우 / null이면 db에서 못찾앗기때문에 실행안됨
			if( !principalService.passwordCheck(passowrd, user)) { //비밀번호 일치하면 true->실행안됨 -> user객체가 들어있으므로 user객체 리턴 /false면 null 리턴
				return null;
			}
		}
		return user; //true가 나와야 로그인
	}
}
