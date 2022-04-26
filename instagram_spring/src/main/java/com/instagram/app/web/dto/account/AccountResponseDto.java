package com.instagram.app.web.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountResponseDto {
	private int usercode;
	private String username;
	private String name;
	private String email;
	private String phone;
	private String imgUrl;
	private String website;
	private String introduce;
	private int gender;
}
