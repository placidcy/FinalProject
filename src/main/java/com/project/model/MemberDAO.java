package com.project.model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDAO {

	private JdbcTemplate jdbcTemplate;
	private String sql;
	
	public MemberDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public MemberDO login(String m_acctid, String m_acctpwd) {
		MemberDO member = null;
		this.sql = "select m_name, m_acctid, m_acctpwd, m_email, m_tel, m_dept, m_pfp, m_role"
				+ "from final_member"
				+ "where m_acctid=? and m_acctpwd=?";
		
		member = this.jdbcTemplate.queryForObject(sql, new MemberRowMapper(), m_acctid, m_acctpwd);
		return member;
	}
	
	public int insertMember(MemberDO member) {
		this.sql = "insert into final_member (member_id, m_acctid, m_acctpwd, m_name, m_email, m_tel, m_dept, m_status, m_role) "
				+ "values (seq_member_id.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			return this.jdbcTemplate.update(sql, member.getM_acctid(), member.getM_acctpwd(), member.getM_name(), member.getM_email(), member.getM_tel(), member.getM_dept(), member.getM_status(), member.getM_role());			
		}
		catch(DuplicateKeyException e) {
			throw new RuntimeException("아이디 혹은 이메일이 중복되었습니다.");
		}
	}
	
	public int updateEmail(MemberDO member) {
		this.sql = "update final_member"
				+ "set m_email=?"
				+ "where member_id=?";
		return this.jdbcTemplate.update(sql, member.getM_email(), member.getMember_id());
	}
	
	public int updatePassword(MemberDO member) {
		this.sql = "update final_member"
				+ "set m_acctpwd=?"
				+ "where member_id=?";
		return this.jdbcTemplate.update(sql, member.getM_acctpwd(), member.getMember_id());
	}
	
	public int updateMemberStatus(MemberDO member) {
		this.sql = "update final_member"
				+ "set m_status=?"
				+ "where member_id=?";
		return this.jdbcTemplate.update(sql, member.getM_status(), member.getMember_id());
	}
	
	public int updateMemberProfile(MemberDO member) {
		this.sql = "update final_member"
				+ "set m_pfp=?"
				+ "where member_id=?";
		return this.jdbcTemplate.update(sql, member.getM_pfp());
	}
	
	public int deleteMemberInfo(MemberDO member) {
		this.sql = "delete from final_member"
				+ "where member_id=?";
		return this.jdbcTemplate.update(sql, member.getMember_id());
	}
}
