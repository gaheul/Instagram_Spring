package com.instagram.app.domain.profile;

import com.instagram.app.domain.user.User;

public interface ProfileRepository {
	public Account getAccountProfileByUsercode(int usercode);
	public int updateUserMst(Account account);
	public int updateUserDtl(Account account);
	public int updatePassword(User user);
	public int updateProfileImg(ProfileImg profileImg);
	public ProfileImg getProfileImg(int usercode);
}
