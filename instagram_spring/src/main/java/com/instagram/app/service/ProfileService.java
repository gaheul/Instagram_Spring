package com.instagram.app.service;

import com.instagram.app.web.dto.account.AccountResponseDto;

public interface ProfileService {
	public AccountResponseDto getAccountProfile(int usercode);
}
