package com.project.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CourseRowMapper implements RowMapper<CourseDO> {
    @Override
    public CourseDO mapRow(ResultSet rs, int rowNum) throws SQLException {
    	CourseDO course = new CourseDO();
    	course.setCourse_id(rs.getInt("course_id"));
    	course.setCategory_id(rs.getInt("category_id"));
    	course.setC_name(rs.getString("c_name"));
    	course.setC_desc(rs.getString("c_desc"));
    	course.setC_sdate(rs.getTimestamp("c_sdate").toLocalDateTime());
    	course.setC_edate(rs.getTimestamp("c_edate").toLocalDateTime());
    	course.setC_limits(rs.getInt("c_limits"));
    	course.setC_prsscore(rs.getInt("c_prsscore"));
    	course.setC_absscore(rs.getInt("c_absscore"));
    	course.setC_trdscore(rs.getInt("c_trdscore"));
        
        return course;
    }
}
