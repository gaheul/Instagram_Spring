package com.instagram.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.service.AuthService;
import com.instagram.app.web.dto.auth.SignupRequestDto;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
	public String getSignup(SignupRequestDto signupRequestDto) { //dto로 생성 :변수명이 쿼리스트링이랑 일치
		                    //@RequestParam(name) 매개변수 ->name값만 맞춰주면됨 /변수명이 name과 같으면 (name)생략가능 /@RequestParam(name)생략가능
		System.out.println("phoneOrEmail : " + signupRequestDto.getPhoneOrEmail());
		System.out.println("name : " + signupRequestDto.getName());
		System.out.println("username : " + signupRequestDto.getUsername());
		System.out.println("password : " + signupRequestDto.getPassword());
		return "auth/signup";
	}
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.POST)
	public String signupSubmit(SignupRequestDto signupRequestDto) {
		System.out.println(signupRequestDto);
		return null;
	}
	
	@ResponseBody //데이터만 주고받음
	@RequestMapping(value = "/auth/username/check", method = RequestMethod.GET)
	public String usernameCheck(String username) {
		
		return Boolean.toString(authService.checkUsername(username));
	}
}
