package com.project.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CourseBoardRowMapper implements RowMapper<CourseBoardDO> {
    @Override
    public CourseBoardDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CourseBoardDO post = new CourseBoardDO();
        post.setPostId(rs.getInt("post_id"));
        post.setTitle(rs.getString("p_title"));
        post.setContents(rs.getString("p_contents"));
        post.setRegDate(rs.getString("p_regdate"));
        post.setTypeId(rs.getInt("type_id"));
        return post;
    }
}