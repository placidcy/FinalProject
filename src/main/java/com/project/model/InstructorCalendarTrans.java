package com.project.model;

import java.time.LocalDateTime;
import java.util.List;

public class InstructorCalendarTrans {
	
	private LocalDateTime dt;
	private int d;
	private List<InstructorCalendar> insCalendar;
	
	public InstructorCalendarTrans() {
	}

	public LocalDateTime getDt() {
		return dt;
	}

	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public List<InstructorCalendar> getInsCalendar() {
		return insCalendar;
	}

	public void setInsCalendar(List<InstructorCalendar> insCalendar) {
		this.insCalendar = insCalendar;
	}


	
	
	
}
