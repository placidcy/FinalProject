package com.project.model.dao;

import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.project.model.CourseMaterialWriteDO;

@Repository
public class CourseMaterialWriteDAO {

    private final JdbcTemplate jdbcTemplate;

    public CourseMaterialWriteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int savePost(CourseMaterialWriteDO courseMaterial) {
        String sql = "INSERT INTO FINAL_COURSE_POST (POST_ID, TYPE_ID, USER_ID, COURSE_ID, P_TITLE) VALUES (SEQ_POST_ID.NEXTVAL, 2, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"POST_ID"});
            ps.setInt(1, courseMaterial.getUserId());
            ps.setInt(2, courseMaterial.getCourseId());
            ps.setString(3, courseMaterial.getTitle());
            return ps;
        }, keyHolder);

        return keyHolder.getKey() != null ? keyHolder.getKey().intValue() : 0;
    }

    public void saveAttachment(int postId, String fileName) {
        String sql = "INSERT INTO final_post_attm (POST_ID, P_ATTM) VALUES (?, ?)";
        jdbcTemplate.update(sql, postId, fileName);
    }
}
