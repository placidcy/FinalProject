package com.project.model;

import java.sql.*;
import java.util.List;
import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class AttendanceDAO {

	private final JdbcTemplate jdbcTemplate;
	private String sql;

	public AttendanceDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<MemberDO> selectAllMemberByCourse(int course_id){
		this.sql = "select * from final_member where member_id in (select member_id from final_course_student where course_id = ?)";
		return this.jdbcTemplate.query(sql, new MemberRowMapper(),course_id);
	}
	

	
}
