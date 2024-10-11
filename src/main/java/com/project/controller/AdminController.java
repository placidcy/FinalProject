package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.response.LoginResponse;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@GetMapping("/adminMain")
	public String adminMainHandler(HttpSession session, Model model) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if(auth.getM_role()!=0) {

			return "/";
		}
		
		model.addAttribute("menu", "adminMain");
		return "adminMain";
	}
	
	@GetMapping("/instructorManagement")
	public String instructorManagementHandler(HttpSession session, Model model) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if(auth.getM_role()!=0) {

			return "/";
		}
		model.addAttribute("menu", "instructorManagement");
		return "instructorManagement";
	}
}
