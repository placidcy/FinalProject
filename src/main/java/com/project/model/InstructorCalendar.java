package com.project.model;

import java.time.LocalDateTime;

public class InstructorCalendar {

	private int i_schedule_id;
	private LocalDateTime s_sdate;
	private LocalDateTime s_edate;
	private String s_title;
	private String s_attm;
	private String s_memo;
	
	public InstructorCalendar() {
	}
	
	public int getI_schedule_id() {
		return i_schedule_id;
	}

	public void setI_schedule_id(int i_schedule_id) {
		this.i_schedule_id = i_schedule_id;
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

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_attm() {
		return s_attm;
	}

	public void setS_attm(String s_attm) {
		this.s_attm = s_attm;
	}

	public String getS_memo() {
		return s_memo;
	}

	public void setS_memo(String s_memo) {
		this.s_memo = s_memo;
	}
	
	
	
	
	
}

