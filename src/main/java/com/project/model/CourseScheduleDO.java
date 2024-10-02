package com.project.model;

import java.time.LocalDateTime;

public class CourseScheduleDO {

	private int course_id;
	private LocalDateTime s_sdate;
	private LocalDateTime s_edate;
	private String s_stime;
	private String s_etime;
	private int s_cintime;
	private int s_couttime;
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
	public int getS_cintime() {
		return s_cintime;
	}
	public void setS_cintime(int s_cintime) {
		this.s_cintime = s_cintime;
	}
	public int getS_couttime() {
		return s_couttime;
	}
	public void setS_couttime(int s_couttime) {
		this.s_couttime = s_couttime;
	}
	
	
	
}
