package com.project.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.model.QuestionDO;
import com.project.model.QuestionRowMapper;

@Repository
public class QuestionDAO {
	private JdbcTemplate jdbcTemplate;

	public QuestionDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<QuestionDO> getQuestions(int courseId) {
		String sql = "SELECT q.post_id, q.p_title AS title, "
				+ "TO_CHAR(q.p_regdate, 'YYYY-MM-DD HH24:MI:SS') AS regDate, "
				+ "(SELECT COUNT(*) FROM final_post_reply WHERE post_id = q.post_id) AS replyCount "
				+ "FROM final_course_post q " + "WHERE course_id = ? AND type_id = 3 " + "ORDER BY q.p_regdate DESC";

		return this.jdbcTemplate.query(sql, new QuestionRowMapper(), courseId);
	}
}
