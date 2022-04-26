package com.instagram.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instagram.app.web.dto.auth.SignupRequestDto;

@Controller
public class PageController {//필요한 page의 데이터
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.GET) //script에서 get요청 날림
	public String getSingin() {
		return "auth/signin";
	}
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.GET) //script에서 get요청 날림
	public String getSingup() {
		return "auth/signup";
	}
	
	/*
	 * @RequestMapping(value = "/auth/signup", method = RequestMethod.GET) public
	 * String getSignup(SignupRequestDto signupRequestDto) { //dto로 생성 :변수명이 쿼리스트링이랑
	 * 일치 //@RequestParam(name) 매개변수 ->name값만 맞춰주면됨 /변수명이 name과 같으면 (name)생략가능
	 * /@RequestParam(name)생략가능
	 * 
	 * return "auth/signup"; }
	 */
	
	@RequestMapping(value = "/profile/account",method = RequestMethod.GET)
	public String getAccount() {
		return "profile/account/account";
	}
	
}
