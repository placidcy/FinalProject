package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.CourseNoticeItem;
import com.project.model.dao.CourseNoticeDAO;

@Controller
public class CourseController {
	@Autowired
	private CourseNoticeDAO courseNoticeDAO;

	@GetMapping("/home")
	public String course_homeHandler() {
		return "course_home";
	}

	@GetMapping("/alert")
	public String alertHandler() {
		return "alert";
	}

	@GetMapping("acceptanceManagement")
	public String acceptance_managementHandler() {
		return "acceptance_management";
	}

	@GetMapping("calendarForm")
	public String calendarFormHandler() {
		return "calendarForm";
	}

	@GetMapping("courseAttend")
	public String courseAttendHandler() {
		return "course_attend";
	}

	@GetMapping("/courseNotice")
	public String getCourseNotices(Model model,
			@RequestParam(required = false, defaultValue = "1", name = "page") String page) {
		int pageNum = Integer.parseInt(page);
		model.addAttribute("courseAnnouncements", courseNoticeDAO.selectAll(pageNum, 10)); // 첫 페이지의 공지사항 10개 가져오기
		model.addAttribute("size", courseNoticeDAO.getCount());
		model.addAttribute("page", pageNum);
		model.addAttribute("menu", "courseNotice");
		return "course_notice"; // JSP 파일 이름
	}
}
