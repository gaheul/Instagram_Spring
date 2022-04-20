package com.instagram.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
	public String getSignup() {
		return "auth/signup";
	}
}
