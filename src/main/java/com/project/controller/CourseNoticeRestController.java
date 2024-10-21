package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.CourseNoticeItem;
import com.project.model.dao.CourseNoticeDAO;
import com.project.model.response.ErrorResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseNoticeRestController {
	@Autowired
	private CourseNoticeDAO noticeDao;
	
	@GetMapping("/getCourseNoticePosts")
	public ResponseEntity<Object> getCourseNoticePosts() {
		List<CourseNoticeItem> noticeList = this.noticeDao.selectAll(1, 10);
		
		if(noticeList == null || noticeList.isEmpty() == true) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("empty noticeList"));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(noticeList);
	}
}
