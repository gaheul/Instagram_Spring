package com.instagram.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.domain.profile.ProfileRepository;
import com.instagram.app.web.dto.account.AccountResponseDto;

import lombok.RequiredArgsConstructor;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	
	@Override
	public AccountResponseDto getAccountProfile(int usercode) {
		
		return profileRepository.getAccountProfileByUsercode(usercode).toDto();
	}
}
