package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseSO {
	@Autowired
	CourseDAO courseDAO;
	
	@Transactional
	public void approveStudent(int course_id, int member_id) {
		
		courseDAO.approveCourseReg(course_id, member_id);
		courseDAO.insertStudent(course_id, member_id);
	}
}
