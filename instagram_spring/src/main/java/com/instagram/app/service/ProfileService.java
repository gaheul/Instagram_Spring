package com.instagram.app.service;

import com.instagram.app.web.dto.account.PasswordUpdateReqDto;
import com.instagram.app.domain.user.User;
import com.instagram.app.web.dto.account.AccountResponseDto;
import com.instagram.app.web.dto.account.AccountUpdateImgReqDto;
import com.instagram.app.web.dto.account.AccountUpdateReqDto;

public interface ProfileService {
	public AccountResponseDto getAccountProfile(int usercode);
	public boolean updateAccount(AccountUpdateReqDto accountUpdateReqDto);
	public boolean updatePassword(User user, PasswordUpdateReqDto passwordUpdateReqDto);
	public boolean updateProfileImg(User user, AccountUpdateImgReqDto accountUpdateImgReqDto);
}
