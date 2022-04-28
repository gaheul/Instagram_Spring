package com.instagram.app.domain.profile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.instagram.app.domain.user.User;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {
	@Autowired
	private SqlSession session;
	
	private final String NAME_SPACE = "com.instagram.app.domain.profile.ProfileRepository.";
	
	@Override
	public Account getAccountProfileByUsercode(int usercode) {
		
		return session.selectOne(NAME_SPACE + "getAccountProfileByUsercode", usercode);
	}
	
	@Override
	public int updateUserMst(Account account) {
		return session.update(NAME_SPACE + "updateUserMst", account);
	}
	
	@Override
	public int updateUserDtl(Account account) {
		return session.update(NAME_SPACE + "updateUserDtl", account);
	}
	
	@Override
	public int updatePassword(User user) {
		return session.update(NAME_SPACE + "updatePassword",user);
	}

}
