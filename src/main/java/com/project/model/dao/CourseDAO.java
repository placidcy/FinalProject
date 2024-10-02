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

	public List<CourseItem> selectByDates(int startNum, int endNum) {
		this.sqlString = """
				select fcs.course_id, c_title, c_name, c_count, c_limits, to_char(c_sdate, 'yyyy.mm.dd') c_sdate, to_char(c_edate, 'yyyy.mm.dd') c_edate
				from final_course fc
				inner join final_course_category fcc on fc.category_id = fcc.category_id
				inner join (select course_id, count(*) as c_count from final_course_student fcs group by course_id) fcs on fcs.course_id = fc.course_id
				where c_count < c_limits
				order by c_sdate, c_edate desc
				""";
//		and sysdate between e_sdate and e_edate""";
		this.sqlString = setPaging(sqlString, startNum, endNum);

		List<CourseItem> courseItems = this.getJdbcTemplate().query(sqlString, new RowMapper<CourseItem>() {
			@Override
			public CourseItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseItem courseItem = new CourseItem();

				courseItem.setCourseId(rs.getInt("course_id"));
				courseItem.setCourseName(rs.getString("c_name"));
				courseItem.setCategoryName(rs.getString("c_title"));
				courseItem.setLimits(rs.getInt("c_limits"));
				courseItem.setCount(rs.getInt("c_count"));
				courseItem.setStartDate(rs.getString("c_sdate"));
				courseItem.setEndDate(rs.getString("c_edate"));

				return courseItem;
			}
		});

		return courseItems;
	}

	public List<CourseItem> selectByDates(String keyword, int startNum, int endNum) {
		this.sqlString = """
				select fcs.course_id, c_title, c_name, c_count, c_limits, to_char(c_sdate, 'yyyy.mm.dd') c_sdate, to_char(c_edate, 'yyyy.mm.dd') c_edate
				from final_course fc
				inner join final_course_category fcc on fc.category_id = fcc.category_id
				inner join (select course_id, count(*) as c_count from final_course_student fcs group by course_id) fcs on fcs.course_id = fc.course_id
				where c_count < c_limits and c_name like ?
				order by c_sdate, c_edate desc
				""";
//		and sysdate between e_sdate and e_edate""";
		this.sqlString = setPaging(sqlString, startNum, endNum);

		List<CourseItem> courseItems = this.getJdbcTemplate().query(sqlString, new RowMapper<CourseItem>() {
			@Override
			public CourseItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseItem courseItem = new CourseItem();

				courseItem.setCourseId(rs.getInt("course_id"));
				courseItem.setCourseName(rs.getString("c_name"));
				courseItem.setCategoryName(rs.getString("c_title"));
				courseItem.setLimits(rs.getInt("c_limits"));
				courseItem.setCount(rs.getInt("c_count"));
				courseItem.setStartDate(rs.getString("c_sdate"));
				courseItem.setEndDate(rs.getString("c_edate"));

				return courseItem;
			}
		}, "%" + keyword + "%");

		return courseItems;
	}

	public int getCountByDates() {
		this.sqlString = """
				select count(*) as cnt
				from final_course fc
				inner join (select course_id, count(*) as c_count from final_course_student fcs group by course_id) fcs on fcs.course_id = fc.course_id
				where c_count < c_limits
				""";

		return this.getJdbcTemplate().queryForObject(sqlString, Integer.class);
	}

	public int getCountByDates(String keyword) {
		this.sqlString = """
				select count(*) as cnt
				from final_course fc
				inner join (select course_id, count(*) as c_count from final_course_student fcs group by course_id) fcs on fcs.course_id = fc.course_id
				where c_count < c_limits and c_name like ?
				""";

		return this.getJdbcTemplate().queryForObject(sqlString, Integer.class, "%" + keyword + "%");
	}

	public List<CourseItem> selectByMemberId(int memberId, int startNum, int endNum) {
		this.sqlString = """
				select fcs.course_id, c_title, c_name
				from final_course fc
				inner join final_course_category fcc on fc.category_id = fcc.category_id
				inner join final_course_student fcs on fc.course_id = fcs.course_id
				where member_id = ? """;
//		and sysdate between c_sdate-14 and c_edate+14""";
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

	public int getCountByMemberId(int memberId) {
		this.sqlString = """
				select count(*) as cnt
				from final_course fc
				inner join final_course_student fcs on fc.course_id = fcs.course_id
				where member_id = ?
				""";

		return this.getJdbcTemplate().queryForObject(sqlString, Integer.class, memberId);
	}
}
