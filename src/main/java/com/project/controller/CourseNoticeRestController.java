package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.CourseDAO;
import com.project.model.CourseDO;
import com.project.model.CourseNoticeItem;
import com.project.model.CourseNoticePostItem;
import com.project.model.dao.CourseNoticeDAO;
import com.project.model.response.ErrorResponse;
import com.project.model.response.LoginResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class CourseNoticeRestController {
	@Autowired
	private CourseNoticeDAO noticeDao;

	@Autowired
	private CourseDAO courseDAO;

	@GetMapping("/getCourseNoticePosts")
	public ResponseEntity<Object> getCourseNoticePosts() {
		List<CourseNoticePostItem> noticeList = this.noticeDao.getAllNoticePosts();

		if (noticeList == null || noticeList.isEmpty() == true) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("empty noticeList"));
		}

		else {
			return ResponseEntity.status(HttpStatus.OK).body(noticeList);
		}
	}

	@GetMapping("/getCourseName")
	public ResponseEntity<Object> getCourseName(HttpSession IdSession) {
		int courseId = (int) IdSession.getAttribute("currentId");

		String courseName = this.courseDAO.getCourseName(courseId);

		if (courseName != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(courseName);
		}

		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/getCourseId")
	public ResponseEntity<Object> getCourseId(HttpSession session) {
		int courseId = 0;
		
		if (session.getAttribute("currentId") != null) {
			courseId = (int)session.getAttribute("currentId");
			CourseDO result = this.noticeDao.getCourseId(courseId);
			
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}

		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	/*
	 * @GetMapping("/notices") public String setCourseNoticePostPath(HttpSession
	 * session, HttpServletRequest clientRequest) { LoginResponse loginResInfo =
	 * (LoginResponse)session.getAttribute("auth");
	 * 
	 * int courseId = (int)session.getAttribute("currentId");
	 * 
	 * int userId = loginResInfo.getMember_id(); int userRole =
	 * loginResInfo.getM_role();
	 * 
	 * if (loginResInfo != null) { String mainUrl =
	 * clientRequest.getRequestURL().toString().replace(clientRequest.getRequestURI(
	 * ), ""); String redirectUrl = mainUrl.replace(":" +
	 * clientRequest.getServerPort(), ":3000");
	 * 
	 * return mainUrl + "/notices?courseId=" + courseId + "&userId=" + userId +
	 * "&role=" + userRole; }
	 * 
	 * return "redirect:/error"; }
	 * 
	 * @GetMapping("/notices/{courseId}")
	 * 
	 * @ResponseBody public List<CourseNoticePostItem>
	 * getAllCourseNoticePosts(@PathVariable("courseId") int courseId, HttpSession
	 * session) { if (courseId == (int) session.getAttribute("currentId")) {
	 * List<CourseNoticePostItem> noticePosts = this.noticeDao.getAllNoticePosts();
	 * 
	 * return noticePosts; }
	 * 
	 * return null; }
	 */

}
