package com.instagram.app.web.dto.account;

import com.instagram.app.domain.profile.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountUpdateReqDto {
	private int usercode;
	private String username;
	private String name;
	private String website;
	private String introduce;
	private String email;
	private String phone;
	private int gender;
	
	public Account toEntity() {
		return Account.builder()
				.usercode(usercode)
				.username(username)
				.name(name)
				.website(website)
				.introduce(introduce)
				.email(email)
				.phone(phone)
				.gender(gender)
				.build();
	}
}
