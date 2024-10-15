package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AttendanceSO {

	@Autowired
	private AttendanceDAO attDao;
	
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
}
