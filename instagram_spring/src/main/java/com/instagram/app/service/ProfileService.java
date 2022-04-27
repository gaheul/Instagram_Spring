package com.instagram.app.service;

import com.instagram.app.web.dto.account.AccountResponseDto;
import com.instagram.app.web.dto.account.AccountUpdateReqDto;

public interface ProfileService {
	public AccountResponseDto getAccountProfile(int usercode);
	public boolean updateAccount(AccountUpdateReqDto accountUpdateReqDto);
}
