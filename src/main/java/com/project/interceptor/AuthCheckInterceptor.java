package com.project.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthCheckInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			Object auth = session.getAttribute("auth");
			if(auth != null) return true;
		}
		response.sendRedirect("/login");
		
		return false;
	}
}