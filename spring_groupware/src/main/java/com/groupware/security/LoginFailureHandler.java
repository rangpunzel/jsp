package com.groupware.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		//exception : BadCredentialsException이 나감
		
		request.setAttribute("msg", exception.getMessage());
//		request.setAttribute("msg", "아이디 혹은 패스워드가 일치하지 않습니다.");
		
		super.onAuthenticationFailure(request, response, exception);
	}

	
}
