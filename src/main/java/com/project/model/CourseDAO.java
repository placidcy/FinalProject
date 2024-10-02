package com.project.model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class CourseDAO {
	private JdbcTemplate jdbcTemplate;
	private String sql;

	public CourseDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public CourseDO getCourseScore(int course_id) {
		this.sql="select * from final_course where course_id=?";
		return this.jdbcTemplate.queryForObject(sql, new CourseRowMapper(),course_id);
	}
}
