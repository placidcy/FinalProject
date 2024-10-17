package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.CourseBoardDO;
import com.project.model.dao.CourseNoticeDAO;
import com.project.service.CourseBoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CourseController {
	@Autowired
	private CourseNoticeDAO courseNoticeDAO;
	
	@Autowired
	private CourseBoardService courseBoardService;
	
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

	@GetMapping("/courseAttend")
    public String courseAttendHandler(Model model,
            @RequestParam(required = false, defaultValue = "1", name = "page") String page) {
        int pageNum = Integer.parseInt(page);
        model.addAttribute("courseAnnouncements", courseNoticeDAO.selectAll(pageNum, 10));
        model.addAttribute("size", courseNoticeDAO.getCount());
        model.addAttribute("page", pageNum);
        model.addAttribute("menu", "courseAttend");
        return "course_attend";
    }

	@GetMapping("/courseNotice")
	public String getCourseNotices(Model model,
			@RequestParam(required = false, defaultValue = "1", name = "page") String page) {
		int pageNum = Integer.parseInt(page);
		model.addAttribute("courseAnnouncements", courseNoticeDAO.selectAll(pageNum, 10));
		model.addAttribute("size", courseNoticeDAO.getCount());
		model.addAttribute("page", pageNum);
		model.addAttribute("menu", "courseNotice");
		return "course_notice";
	}
	
	
	// 리액트 테스트
//	@GetMapping("/reactTest")
//    public String reactTestHandler() {
//        return "reactTest";
//    }
	
	@GetMapping("/CourseBoard")
	public String goToCourseBoard(HttpSession session, HttpServletRequest request) {
	    Integer courseId = (Integer) session.getAttribute("currentId");
	    if (courseId != null) {
	        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
	        String redirectUrl = baseUrl.replace(":" + request.getServerPort(), ":3000");
	        
	        return "redirect:" + redirectUrl + "/CourseBoard?courseId=" + courseId;
	    }
	    return "redirect:/error";
	}
	
	@GetMapping("/api/coursesBoard/{courseId}")
	@ResponseBody
	public List<CourseBoardDO> getAllPosts(@PathVariable("courseId") int courseId) {
		List<CourseBoardDO> posts = courseBoardService.getAllPosts(courseId);
		for (CourseBoardDO post : posts) {
	        List<String> attachments = courseBoardService.getAttachmentsByPostId(post.getPostId());
	        post.setAttachments(attachments);
	    }
	    return posts;
	}
	
	@GetMapping("/api/getCourseId")
	@ResponseBody
	public Integer getCourseId(HttpSession session) {
	    return (Integer) session.getAttribute("currentId");
	}
	
}
