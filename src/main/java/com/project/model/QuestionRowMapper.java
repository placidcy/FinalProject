package com.project.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class QuestionRowMapper implements RowMapper<QuestionDO> {
    @Override
    public QuestionDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuestionDO question = new QuestionDO();
        question.setPostId(rs.getInt("post_id"));
        question.setTitle(rs.getString("title"));
        question.setRegDate(rs.getString("regDate"));
        question.setReplyCount(rs.getInt("replyCount"));
        return question;
    }
}
