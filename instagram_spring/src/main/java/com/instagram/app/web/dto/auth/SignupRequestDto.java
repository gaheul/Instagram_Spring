package com.instagram.app.web.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupRequestDto { //변수명이 쿼리스트링(name)이랑 일치
	private String phoneOrEmail;
	private String name;
	private String username;
	private String password;
}
