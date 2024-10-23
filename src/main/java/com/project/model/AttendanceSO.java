package com.project.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	public List<InstructorCalendarTrans> getTransInsCalendar(int course_id, int c_year, int c_month) {
		List<InstructorCalendarTrans> insCalendarTransList = new ArrayList<InstructorCalendarTrans>();
		List<InstructorCalendar> insCalendarList = attDao.getInstructorCalendar(course_id, c_year, c_month);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR , c_year);
		cal.set(Calendar.MONTH , c_month-1);
		
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int s_day = cal.get(Calendar.DAY_OF_WEEK);


		for(int i=1; i<=lastDate; i++) {
			InstructorCalendarTrans insCal = new InstructorCalendarTrans();
			List<InstructorCalendar> calendarList = new ArrayList<InstructorCalendar>();
			insCal.setDt(LocalDateTime.of(c_year, c_month, i, 0, 0));
			insCal.setD((s_day+i+2)%7+1);
			for(InstructorCalendar insCalendar : insCalendarList) {
				if(insCalendar.getS_edate().getYear()==c_year && insCalendar.getS_edate().getMonthValue()==c_month) {
					if(insCalendar.getS_sdate().getDayOfMonth()<=i && insCalendar.getS_edate().getDayOfMonth()>=i){
						calendarList.add(insCalendar);
					}
					
				}else {
					if(insCalendar.getS_sdate().getDayOfMonth()<=i) {
					calendarList.add(insCalendar);
					}
				}
			}
			insCal.setInsCalendar(calendarList);
			insCalendarTransList.add(insCal);
			
		}
		
		return insCalendarTransList;

		
	}
	
}
