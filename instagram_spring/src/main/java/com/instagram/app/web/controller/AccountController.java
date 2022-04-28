package com.instagram.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.auth.PrincipalService;
import com.instagram.app.domain.user.User;
import com.instagram.app.service.AuthService;
import com.instagram.app.service.ProfileService;
import com.instagram.app.web.dto.account.PasswordUpdateReqDto;
import com.instagram.app.web.dto.account.AccountResponseDto;
import com.instagram.app.web.dto.account.AccountUpdateReqDto;

import lombok.RequiredArgsConstructor;

@Controller
public class AccountController {
	
	@Autowired
	private  ProfileService profileService;
	@Autowired
	private PrincipalService principalService;
	
	@ResponseBody
	@RequestMapping(value = "/profile/account/user", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public AccountResponseDto getProfile(int usercode) {
		
		return profileService.getAccountProfile(usercode);
	}
	
	@ResponseBody
	@RequestMapping(value = "/profile/account/update", method = RequestMethod.PUT)
	public String updateAccount(@RequestBody AccountUpdateReqDto accountUpdateReqDto, HttpServletRequest request) {//@RequestBody ->json데이터를 객체로 받을수있음
		boolean result = profileService.updateAccount(accountUpdateReqDto);
		if(result == true) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", principalService.loadUserByUsername(accountUpdateReqDto.getUsername()));
		}
		return Boolean.toString(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "/profile/account/password/update", method = RequestMethod.PUT)
	public String updateAccountPassword(@RequestBody PasswordUpdateReqDto passwordUpdateReqDto,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("principal");
		if(!BCrypt.checkpw(passwordUpdateReqDto.getOriginPassword(), user.getPassword())) {
			return "false";
		}
		return Boolean.toString( profileService.updatePassword(user, passwordUpdateReqDto));
	}
}
