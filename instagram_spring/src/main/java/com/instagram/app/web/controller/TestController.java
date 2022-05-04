package com.instagram.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String aaa() {
		return "auth/signup"; //jsp 페이지 return 
	}
	
	@ResponseBody //return이 view resolver로 안가고 body에 데이터 넣음
	@RequestMapping(value = "/bbb", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")//한글넣었을 때 res하면 한글안깨짐(produces)
	public String bbb() {
		return "hello"; //원하는 text return
	}
}
