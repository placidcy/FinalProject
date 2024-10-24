package com.project.model.dao;

import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.project.model.CourseQuestionWriteDO;

@Repository
public class CourseQuestionWriteDAO {

	private final JdbcTemplate jdbcTemplate;

	public CourseQuestionWriteDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveQuestion(CourseQuestionWriteDO question) {
		String sql = "INSERT INTO FINAL_COURSE_POST (POST_ID, TYPE_ID, MEMBER_ID, COURSE_ID, P_TITLE, P_CONTENTS) "
				+ "VALUES (SEQ_POST_ID.NEXTVAL, 3, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, new String[] { "POST_ID" });
			ps.setInt(1, question.getMemberId());
			ps.setInt(2, question.getCourseId());
			ps.setString(3, question.getTitle());
			ps.setString(4, question.getContent());
			return ps;
		}, keyHolder);

		return keyHolder.getKey() != null ? keyHolder.getKey().intValue() : 0;
	}
}
