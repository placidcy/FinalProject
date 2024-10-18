package com.project.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.project.model.JWT.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthCheckInterceptor implements HandlerInterceptor{

	/*
	 * @Autowired private JwtUtil jwtUtil;
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			Object auth = session.getAttribute("auth");
			if(auth != null) return true;
		}
		response.sendRedirect("/login");
		
		return false;
		
		/*
		 * //토큰구현중단 String auth = request.getHeader("Authorization");
		 * 
		 * if(auth == null || !auth.startsWith("Bearer ")) {
		 * response.sendRedirect("/login"); return false; }
		 * 
		 * String token = auth.substring(7); try { String username =
		 * jwtUtil.extractUsername(token); if(username != null &&
		 * !jwtUtil.isTokenExpired(token)) { return true; } else {
		 * response.sendRedirect("/login"); return false; } } catch (Exception e) {
		 * response.sendRedirect("/login"); return false; }
		 */
		
	}
}