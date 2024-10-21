package com.project.model;

import java.time.format.DateTimeFormatter;

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
	
	public CourseDO getCourseDetails(int course_id) {
		CourseDO course = courseDAO.getCourseScore(course_id);
		
		// 포맷변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		course.setC_sdateFormatted(course.getC_sdate().format(formatter));
        course.setC_edateFormatted(course.getC_edate().format(formatter));

        return course;
	}
}
