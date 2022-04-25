package com.instagram.app.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.instagram.app.domain.user.User;

@Component
public class AuthFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		
		HttpSession session = httpServletRequest.getSession();
		User user=(User)session.getAttribute("principal");
		
		String path = httpServletRequest.getRequestURI();
		
		if(path.contains("/app/auth")) { //요청주소에 auth가 포함되어있을 때
			if(user != null) { 
				httpServletResponse.sendRedirect("/app/"); //index로 전달
				return;
			}
		}else if(path.contains("/app/static")){
			//그냥 넘어감(아무요청없음)
		}else {		
			if(user == null) { //로그인 안되어져있으면
				httpServletResponse.sendRedirect("/app/auth/signin");
				return;
			}
			
		}
		
		
		chain.doFilter(httpServletRequest, httpServletResponse);
	}
	
	@Override
	public void destroy() {
	
	}
}
