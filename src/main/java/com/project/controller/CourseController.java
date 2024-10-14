package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.AttendanceCalendar;
import com.project.model.AttendanceDAO;
import com.project.model.CourseDAO;
import com.project.model.CourseDO;
import com.project.model.CourseNoticeItem;
import com.project.model.CourseReg;
import com.project.model.StudentAttendanceDO;
import com.project.model.dao.CourseNoticeDAO;
import com.project.model.response.LoginResponse;

import jakarta.servlet.http.HttpSession;

@Controller
public class CourseController {
	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private CourseNoticeDAO courseNoticeDAO;
	
	@Autowired
	private AttendanceDAO attendanceDAO;

	@GetMapping("/home")
	public String course_homeHandler(HttpSession session, Model model) {
		
		model.addAttribute("menu", "home");
		return "course_home";
	}

	@GetMapping("/alert")
	public String alertHandler() {
		return "alert";
	}
	
	@GetMapping("acceptanceManagement")
	public String acceptance_managementHandler(@RequestParam(value="acceptPage", defaultValue="0") int acceptPage, HttpSession session, Model model) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if(auth.getM_role()==2) {
		
		//int course_id = (int) session.getAttribute("course_id");
		/*나중에 삭제할 것*/
		int course_id=3;
		List<CourseReg> courseRegList = courseDAO.getCourseReg(course_id);
		model.addAttribute("courseRegList", courseRegList);
		model.addAttribute("acceptPage",acceptPage);
		model.addAttribute("menu", "acceptanceManagement");
		
		return "acceptance_management";
		}
		
		return "redirect:/" ;
	}
	
	@PostMapping("/acceptanceManagementSearch")
	public String currentAttSearchHandler(@RequestParam(value="acceptPage", defaultValue="0") int acceptPage, HttpSession session, @RequestParam(value="searchType") String searchType, @RequestParam(value="searchText") String searchText, Model model) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
			//int course_id = (int) session.getAttribute("course_id");
			/*나중에 삭제할 것*/
				
			int course_id = 3;
		
			List<CourseReg> courseRegList = courseDAO.searchMemberReg(course_id, searchType, searchText);
			model.addAttribute("courseRegList", courseRegList);
			model.addAttribute("acceptPage",acceptPage);
			model.addAttribute("menu", "acceptanceManagement");
			
			return "acceptance_management";
			}
			
			return "redirect:/" ;
	}

	@GetMapping("calendarForm")
	public String calendarFormHandler() {
		return "calendarForm";
	}

	@GetMapping("courseAttend")
	public String courseAttendHandler(HttpSession session, Model model) {
		LoginResponse auth = (LoginResponse) session.getAttribute("auth");
		if(auth.getM_role()==2) {
		model.addAttribute("menu", "courseAttend");
		
		return "course_attend";
		}
		return "redirect:/" ;
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
