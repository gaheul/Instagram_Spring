package com.instagram.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.domain.profile.ProfileRepository;
import com.instagram.app.domain.user.User;
import com.instagram.app.domain.user.UserRepository;
import com.instagram.app.web.dto.account.AccountResponseDto;
import com.instagram.app.web.dto.account.AccountUpdateReqDto;
import com.instagram.app.web.dto.account.PasswordUpdateReqDto;

import lombok.RequiredArgsConstructor;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public AccountResponseDto getAccountProfile(int usercode) {
		
		return profileRepository.getAccountProfileByUsercode(usercode).toDto();
	}
	
	@Override
	public boolean updateAccount(AccountUpdateReqDto accountUpdateReqDto) {
		//username중복확인
		if(userRepository.checkUsername(accountUpdateReqDto.getUsername()) != 0 ) {
			return false;
		}
		
		profileRepository.updateUserMst(accountUpdateReqDto.toEntity());
		profileRepository.updateUserDtl(accountUpdateReqDto.toEntity());
		return true;
		
	}
	
	@Override
	public boolean updatePassword(User user, PasswordUpdateReqDto passwordUpdateReqDto) {
		
		user.setPassword(BCrypt.hashpw(passwordUpdateReqDto.getNewPassword(), BCrypt.gensalt()));
		
		return profileRepository.updatePassword(user) != 0;
	}
	
	
}
