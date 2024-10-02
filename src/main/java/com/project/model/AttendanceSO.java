package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceSO {

	@Autowired
	private AttendanceDAO attDao;
	
	
}
