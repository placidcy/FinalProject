package com.project.model;

import java.time.LocalDateTime;

public class MemberDO {
	
	private int member_id;
	private String m_name;
	private String m_acctid;
	private String m_acctpwd;
	private String m_email;
	private String m_tel;
	private String m_dept;
	private String m_pfp;
	private int m_status;
	private int m_role;
	private LocalDateTime deactivationDate;
	
	public MemberDO() {		

	}
	
	public MemberDO(int member_id, String m_name, String m_acctid, String m_acctpwd, String m_email,
			String m_tel, String m_dept, int m_status, int m_role) {
		this.member_id = member_id;
		this.m_name = m_name;
		this.m_acctid = m_acctid;
		this.m_acctpwd = m_acctpwd;
		this.m_email = m_email;
		this.m_tel = m_tel;
		this.m_dept = m_dept;
		this.m_status = m_status;
		this.m_role = m_role;
	}

	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_acctid() {
		return m_acctid;
	}
	public void setM_acctid(String m_acctid) {
		this.m_acctid = m_acctid;
	}
	public String getM_acctpwd() {
		return m_acctpwd;
	}
	public void setM_acctpwd(String m_acctpwd) {
		this.m_acctpwd = m_acctpwd;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_dept() {
		return m_dept;
	}
	public void setM_dept(String m_dept) {
		this.m_dept = m_dept;
	}
	public String getM_pfp() {
		return m_pfp;
	}
	public void setM_pfp(String m_pfp) {
		this.m_pfp = m_pfp;
	}
	public int getM_status() {
		return m_status;
	}
	public void setM_status(int m_status) {
		this.m_status = m_status;
	}
	public int getM_role() {
		return m_role;
	}
	public void setM_role(int m_role) {
		this.m_role = m_role;
	}

	public LocalDateTime getDeactivationDate() {
		return deactivationDate;
	}

	public void setDeactivationDate(LocalDateTime deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

}
