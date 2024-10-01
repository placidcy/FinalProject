package com.project.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.model.CourseItem;

@Repository
public class CourseDAO extends ItemDAO {
	private String sqlString;

	public CourseDAO() {
		super();
	}

	public List<CourseItem> selectCourseItems(int memberId, int startNum, int endNum) {
		this.sqlString = """
				select fcs.course_id, c_title, c_name
				from final_course fc
				inner join final_course_category fcc on fc.category_id = fcc.category_id
				inner join final_course_student fcs on fc.course_id = fcs.course_id
				where member_id = ? and sysdate between c_sdate-14 and c_edate+14
				""";
		this.sqlString = setPaging(sqlString, startNum, endNum);
		List<CourseItem> courseItems = this.getJdbcTemplate().query(sqlString, new RowMapper<CourseItem>() {
			@Override
			public CourseItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseItem courseItem = new CourseItem();

				courseItem.setCourseId(rs.getInt("course_id"));
				courseItem.setCourseName(rs.getString("c_name"));
				courseItem.setCategoryName(rs.getString("c_title"));

				return courseItem;
			}
		}, memberId);

		return courseItems;
	}
}
