package com.instagram.app.domain.profile;

public interface ProfileRepository {
	public Account getAccountProfileByUsercode(int usercode);
}
