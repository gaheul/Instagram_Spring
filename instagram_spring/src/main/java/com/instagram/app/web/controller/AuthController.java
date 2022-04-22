package com.instagram.app.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.service.AuthService;
import com.instagram.app.web.dto.auth.SignupRequestDto;
import com.instagram.app.web.util.auth.AuthResponseScript;
import com.instagram.app.web.validation.auth.AuthValidation;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.GET) //script에서 get요청 날림
	public String getSingin() {
		return "auth/signin";
	}
	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.POST) 
	public String SigninSubmit(String username, String password) throws UnsupportedEncodingException {
		AuthValidation authValidation = new AuthValidation();
		Map<Boolean, String> usernameIsNull = authValidation.isNull("username",username);
		Map<Boolean, String> passwordIsNull = authValidation.isNull("password",password);
		
		if(usernameIsNull != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(usernameIsNull.get(true),"UTF-8");
		}
		if(passwordIsNull != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(passwordIsNull.get(true),"UTF-8");
		}
		
		return "index";
	}
	
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
	public String getSignup(SignupRequestDto signupRequestDto) { //dto로 생성 :변수명이 쿼리스트링이랑 일치
		                    //@RequestParam(name) 매개변수 ->name값만 맞춰주면됨 /변수명이 name과 같으면 (name)생략가능 /@RequestParam(name)생략가능
		
		return "auth/signup";
	}
	
	@ResponseBody
	@RequestMapping(value = "/auth/signup", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String signupSubmit(SignupRequestDto signupRequestDto) {
		boolean result= authService.signup(signupRequestDto);
		AuthResponseScript script = new AuthResponseScript();
		return script.signupScirpt(result);
	}
	
	@ResponseBody //데이터만 주고받음
	@RequestMapping(value = "/auth/username/check", method = RequestMethod.GET)
	public String usernameCheck(String username) {
		
		return Boolean.toString(authService.checkUsername(username));
	}
}
