package com.project.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class CourseScheduleDO {

	private int course_id;
	private LocalDateTime s_sdate;
	private LocalDateTime s_edate;
	private String s_stime;
	private String s_etime;
	private int s_cinterm;
	private int s_coutterm;
	
	public CourseScheduleDO() {
	}
	
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public LocalDateTime getS_sdate() {
		return s_sdate;
	}
	public void setS_sdate(LocalDateTime s_sdate) {
		this.s_sdate = s_sdate;
	}
	public LocalDateTime getS_edate() {
		return s_edate;
	}
	public void setS_edate(LocalDateTime s_edate) {
		this.s_edate = s_edate;
	}
	public String getS_stime() {
		return s_stime;
	}
	public void setS_stime(String s_stime) {
		this.s_stime = s_stime;
	}
	public String getS_etime() {
		return s_etime;
	}
	public void setS_etime(String s_etime) {
		this.s_etime = s_etime;
	}
	public int getS_cinterm() {
		return s_cinterm;
	}
	public void setS_cinterm(int s_cinterm) {
		this.s_cinterm = s_cinterm;
	}
	public int getS_coutterm() {
		return s_coutterm;
	}
	public void setS_coutterm(int s_coutterm) {
		this.s_coutterm = s_coutterm;
	}
	
	public String getZero(int value) {
		String result = Integer.toString(value);
		if(value<10) {
			result = "0" + result;
		}
		return result;

	}
	
	public String getCtime(String ctime, int term) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		String result ="";
		try {
			Date date = formatter.parse(ctime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MINUTE, -term);
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int min = cal.get(Calendar.MINUTE);
			result=getZero(hour)+ ":" + getZero(min);
		}catch(Exception e) {
			
		}
		return result;
		
		
	}
	
	
}
