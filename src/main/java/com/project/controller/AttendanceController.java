package com.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.*;
import com.project.model.response.LoginResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceDAO attendanceDAO;
	
	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private AttendanceSO attendanceSO;
	
	@GetMapping("/attendanceDetail")
	public String attendanceDetailHandler(StudentAttendanceDO studentAtt, HttpSession session, Model model) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
		List<StudentAttendanceDO> attList = attendanceDAO.selectStudentAttendance(studentAtt.getStudent_id());
		List<AttendanceRequest> lvreqList = attendanceDAO.getStudentLvreq(studentAtt.getStudent_id());
		List<AttendanceRequest> correqList = attendanceDAO.getStudentCorreq(studentAtt.getStudent_id());
		
		model.addAttribute("studentAtt", attendanceDAO.getStudentAttendance(studentAtt.getStudent_id()));
		model.addAttribute("attList", attList);
		model.addAttribute("lvreqList", lvreqList);
		model.addAttribute("correqList", correqList);
		model.addAttribute("menu", "currentAttendance");
		
		return "attendanceDetail";
		}
		
		return "redirect:/" ;
	}
	
	@PostMapping("/attResponse")
	public String attResponseHandler(HttpSession session, AttendanceResponse attendanceResponse) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
		attendanceSO.updateAttendanceInfo(attendanceResponse);
		
		return "redirect:attendanceDetail?student_id="+attendanceResponse.getStudent_id();
		}
		
		return "redirect:/" ;
	}
	
	
	/*추후 세션에 저장된 course_id 커맨드 객체나, RequestParam으로 받아오기*/
	/*강의 밑에 강사 밑에 학생을 조회해야할 듯 하다 강의 하나만으로는 강사가 구분 안 됨*/
	@GetMapping("/currentAttendance")
	public String currentAttendanceHandler(HttpSession session, @RequestParam(value="currAttPage", defaultValue="0") int currAttPage, Model model) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
		int course_id = (int) session.getAttribute("currentId");

		
		List<StudentAttendanceDO> studentAttList = attendanceDAO.selectAllMemberAttendanceByCourse(course_id);
		CourseDO courseScore =courseDAO.getCourseScore(course_id);
		
		model.addAttribute("courseScore", courseScore);
		model.addAttribute("currAttPage",currAttPage);
		model.addAttribute("studentAttList", studentAttList);
		model.addAttribute("menu", "currentAttendance");
		
		return "currentAttendance";
		}
		return "redirect:/" ;
	}
	
	@GetMapping("/setAttendance")
	public String setAttendanceHandler(HttpSession session, @RequestParam(value="setAttPage", defaultValue="0") int setAttPage, Model model) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
		int course_id = (int) session.getAttribute("currentId");

		
		List<CourseScheduleDO> courseDateInfo = attendanceDAO.getCourseDateInfo(course_id);
		CourseDO courseScore =courseDAO.getCourseScore(course_id);
		
		model.addAttribute("courseScore", courseScore);
		model.addAttribute("setAttPage",setAttPage);
		model.addAttribute("courseDateInfo", courseDateInfo);
		model.addAttribute("menu", "currentAttendance");
		
		return "setAttendance";
		}
		return "redirect:/" ;
	}
	
	@PostMapping("/setAttendanceScore")
	public String setAttendanceScoreHandler(HttpSession session, CourseDO courseDO) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
			int course_id = (int) session.getAttribute("currentId");
		
		courseDO.setCourse_id(course_id);
		attendanceDAO.updateAttendanceScore(courseDO);
		return "redirect:setAttendance";
		}
		return "redirect:/" ;
	}
	
	@PostMapping("/currentAttSearch")
	public String currentAttSearchHandler(HttpSession session, @RequestParam(value="searchType") String searchType, @RequestParam(value="searchText") String searchText, Model model) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==2) {
		int course_id = (int) session.getAttribute("currentId");

		
		List<StudentAttendanceDO> studentAttList = attendanceDAO.searchMemberAttendance(course_id, searchType, searchText);
		CourseDO courseScore =courseDAO.getCourseScore(course_id);
		
		model.addAttribute("courseScore", courseScore);
		model.addAttribute("currAttPage",0);
		model.addAttribute("studentAttList", studentAttList);
		
		
		return "currentAttendance";
		}
		return "redirect:/" ;
	}
	
	@GetMapping("/attendanceCalendar")
	public String attendanceCalendarHandler(HttpSession session, Model model) {
		LoginResponse auth = (LoginResponse )session.getAttribute("auth");
		if(auth.getM_role()==1) {
			int course_id = (int) session.getAttribute("currentId");

			model.addAttribute("courseDay", attendanceDAO.getCourseDay(course_id));
			model.addAttribute("courseDate", courseDAO.getCourseDate(course_id));
			model.addAttribute("menu", "attendanceCalendar");
			return "attendanceCalendar";
		}
		
		return "redirect:/";
		
	}
	
	// 리액트 사이드바 연동
	@GetMapping("/goAttendanceCalendar")
	public String goAttendanceCalendar(@RequestParam(required = true, name = "courseId") int courseId, HttpSession session) {
	    session.setAttribute("currentId", courseId);
	    return "redirect:/attendanceCalendar";
	}
	
	@GetMapping("/goCurrentAttendance")
	public String goCurrentAttSearch(@RequestParam(required = true, name = "courseId") int courseId, HttpSession session) {
	    session.setAttribute("currentId", courseId);
	    return "redirect:/currentAttendance";
	}
		
}
