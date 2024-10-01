package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberSO {
	
	@Autowired
	private MemberDAO memberDao;
	
	public MemberSO() {
		
	}
}
