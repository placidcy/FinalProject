package com.project.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CourseMaterialRowMapper implements RowMapper<CourseMaterialDO> {
    @Override
    public CourseMaterialDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CourseMaterialDO material = new CourseMaterialDO();
        material.setPostId(rs.getInt("post_id"));
        material.setTitle(rs.getString("p_title"));
        material.setRegDate(rs.getString("p_regdate"));
        return material;
    }
}
