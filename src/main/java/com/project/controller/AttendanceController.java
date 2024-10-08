package com.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.*;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceDAO attendanceDAO;
	
	@Autowired
	private CourseDAO courseDAO;
	
	@GetMapping("/attendanceCalendar")
	public String attendanceCalendarHandler() {
		return "attendanceCalendar";
	}
	
	@GetMapping("/attendanceDetail")
	public String attendanceDetailHandler(StudentAttendanceDO studentAtt, Model model) {
		List<StudentAttendanceDO> attList = attendanceDAO.selectStudentAttendance(studentAtt.getStudent_id());
		List<AttendanceRequest> lvreqList = attendanceDAO.getStudentLvreq(studentAtt.getStudent_id());
		List<AttendanceRequest> correqList = attendanceDAO.getStudentCorreq(studentAtt.getStudent_id());
		
		model.addAttribute("studentAtt", attendanceDAO.getStudentAttendance(studentAtt.getStudent_id()));
		model.addAttribute("attList", attList);
		model.addAttribute("lvreqList", lvreqList);
		model.addAttribute("correqList", correqList);
		
		return "attendanceDetail";
	}
	
	@PostMapping("/attResponse")
	public String attResponseHandler(AttendanceResponse attendanceResponse) {
		attendanceDAO.insertResponse(attendanceResponse);
		
		return "redirect:attendanceDetail?student_id="+attendanceResponse.getStudent_id();
	}
	
	@PostMapping("/attResponseUpdate")
	public String attResponseUpdateHandler(AttendanceResponse attendanceResponse) {
		attendanceDAO.updateResponse(attendanceResponse);
		
		return "redirect:attendanceDetail?student_id="+attendanceResponse.getStudent_id();
	}
	
	
	/*추후 세션에 저장된 course_id 커맨드 객체나, RequestParam으로 받아오기*/
	/*강의 밑에 강사 밑에 학생을 조회해야할 듯 하다 강의 하나만으로는 강사가 구분 안 됨*/
	@GetMapping("/currentAttendance")
	public String currentAttendanceHandler(@RequestParam(value="currAttPage", defaultValue="0") int currAttPage, Model model) {
		List<StudentAttendanceDO> studentAttList = attendanceDAO.selectAllMemberAttendanceByCourse(2);
		CourseDO courseScore =courseDAO.getCourseScore(2);
		
		model.addAttribute("courseScore", courseScore);
		model.addAttribute("currAttPage",currAttPage);
		model.addAttribute("studentAttList", studentAttList);
		
		return "currentAttendance";
	}
	
	@GetMapping("/setAttendance")
	public String setAttendanceHandler(@RequestParam(value="setAttPage", defaultValue="0") int setAttPage, Model model) {
		List<CourseScheduleDO> courseDateInfo = attendanceDAO.getCourseDateInfo(2);
		CourseDO courseScore =courseDAO.getCourseScore(2);
		
		model.addAttribute("courseScore", courseScore);
		model.addAttribute("setAttPage",setAttPage);
		model.addAttribute("courseDateInfo", courseDateInfo);
		
		return "setAttendance";
	}
	
	@PostMapping("/setAttendanceScore")
	public String setAttendanceScoreHandler(CourseDO courseDO) {
		/*세션에서 받아올 거임*/
		courseDO.setCourse_id(2);
		/*이후 삭제할 것*/
		courseDO.setCourse_id(courseDO.getCourse_id());
		attendanceDAO.updateAttendanceScore(courseDO);
		return "redirect:setAttendance";
	}
	
	@PostMapping("/currentAttSearch")
	public String currentAttSearchHandler(@RequestParam(value="currAttPage", defaultValue="0") int currAttPage, @RequestParam(value="searchType") String searchType, @RequestParam(value="searchText") String searchText, Model model) {
		List<StudentAttendanceDO> memberList = attendanceDAO.searchMemberAttendance(2, searchType, searchText);
		CourseDO courseScore =courseDAO.getCourseScore(2);
		
		model.addAttribute("courseScore", courseScore);
		model.addAttribute("currAttPage",currAttPage);
		model.addAttribute("memberList", memberList);
		
		
		return "currentAttendance";
	}
	
	
		
}
