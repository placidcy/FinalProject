package com.project.model;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class PostDAO {

	private JdbcTemplate jdbcTemplate;
	private String sql;

	public PostDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<PostDO> getRecentNoticeByCourse_id(int course_id) {
	    this.sql = "select p_title from ( " +
                "select p_title from final_course_post " +
                "where course_id = ? and type_id = 1 and p_status = 1 " +
                "order by p_regdate desc ) " +
                "where rownum <= 2";

	    return jdbcTemplate.query(sql, (rs, rowNum) -> {
	    	PostDO post = new PostDO();
	        post.setP_title(rs.getString("p_title"));
	        return post;
	    }, course_id);
	}
}
