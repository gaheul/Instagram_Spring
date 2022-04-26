package com.instagram.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.service.ProfileService;
import com.instagram.app.web.dto.account.AccountResponseDto;

import lombok.RequiredArgsConstructor;

@Controller
public class AccountController {
	
	@Autowired
	private  ProfileService profileService;
	
	@ResponseBody
	@RequestMapping(value = "/profile/account/user", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public AccountResponseDto getProfile(int usercode) {
		
		return profileService.getAccountProfile(usercode);
	}
}
