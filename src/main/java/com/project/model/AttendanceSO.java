package com.project.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AttendanceSO {

	@Autowired
	private AttendanceDAO attDao;
	
	@Autowired
	private CourseDAO courseDao;
	
	@Transactional
	public void updateAttendanceInfo(AttendanceResponse attendanceResponse) {
		attDao.insertResponse(attendanceResponse);
		if(attendanceResponse.getReqType() ==1) {
			attDao.updateStudentAttendance(attendanceResponse);
		}
	}
	
	public boolean checkStudentId(int member_id, int course_id) {
		boolean result=false;
		
		try{
			attDao.getStudentId(member_id, course_id);
			result=true;
		}catch(EmptyResultDataAccessException e) {
			
		}
		
		return result;
		
	}
	
	public List<AttendanceCalendar> getHorizonCalendar(int student_id, int c_year, int c_month){
		LocalDateTime dateTime = LocalDateTime.now();
		LocalDateTime c_sdate = courseDao.getCourseDatebyStd(student_id).getC_sdate();
		LocalDateTime c_edate = courseDao.getCourseDatebyStd(student_id).getC_edate();
		List<AttendanceCalendar> result;
		if(dateTime.getYear() < c_sdate.getYear()) {
			result = attDao.getStudentAttendanceCalendar(student_id, c_sdate.getYear(), c_sdate.getMonthValue());
		}else if(dateTime.getYear() > c_edate.getYear()){
			result = attDao.getStudentAttendanceCalendar(student_id, c_edate.getYear(), c_edate.getMonthValue());
		}else if(dateTime.getMonthValue() > c_edate.getMonthValue()) {
			result = attDao.getStudentAttendanceCalendar(student_id, c_edate.getYear(), c_edate.getMonthValue());
		}else if(dateTime.getMonthValue() < c_sdate.getMonthValue()) {
			result = attDao.getStudentAttendanceCalendar(student_id, c_sdate.getYear(), c_sdate.getMonthValue());
		}else {
			result = attDao.getStudentAttendanceCalendar(student_id, c_year, c_month);
		}
		
		return result;
	}
}
