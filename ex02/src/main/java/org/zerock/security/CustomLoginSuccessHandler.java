package org.zerock.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.zerock.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("login 성공~!~!");
		request.getSession().setAttribute("name", ((MemberVO) authentication.getPrincipal()).getName() );
		request.getSession().setAttribute("로그인 대성공", authentication.getPrincipal());
		response.sendRedirect(request.getContextPath()+"/board/list");
	}

}
