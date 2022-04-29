package com.instagram.app.auth;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.domain.profile.ProfileImg;
import com.instagram.app.domain.profile.ProfileRepository;
import com.instagram.app.domain.user.User;
import com.instagram.app.domain.user.UserRepository;

@Service
public class PrincipalServiceImpl implements PrincipalService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public User loadUserByUsername(String username) {
		
		return userRepository.getUserByUsername(username);
	}
	
	@Override
	public boolean passwordCheck(String password, User user) {
		if(BCrypt.checkpw(password, user.getPassword())) {
			return true;
		}else {
			return false;			
		}
	}
	
	@Override
	public ProfileImg getProfileImg(int usercode) {
		return profileRepository.getProfileImg(usercode);
	}
	
	
}
