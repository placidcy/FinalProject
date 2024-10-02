package com.project.model.dao;

import java.sql.*;
import java.util.*;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.model.CourseItem;

@Repository
public class CourseDAO extends ItemDAO {
	private String sql;
	private Map<String, String> query;

	public CourseDAO() {
		super();
		init();
	}

	public List<CourseItem> selectByDates(int startNum, int endNum) {
		this.sql = query.get("selectByDates");
//		and sysdate between e_sdate and e_edate""";
		this.sql = setPaging(sql, startNum, endNum);

		List<CourseItem> courseItems = this.getJdbcTemplate().query(sql, new RowMapper<CourseItem>() {
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
		this.sql = "select * from (" + query.get("selectByDates") + ") where c_name like ?";
//		and sysdate between e_sdate and e_edate""";
		this.sql = setPaging(sql, startNum, endNum);

		List<CourseItem> courseItems = this.getJdbcTemplate().query(sql, new RowMapper<CourseItem>() {
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
		this.sql = query.get("getCountByDates");

		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int getCountByDates(String keyword) {
		this.sql = query.get("getCountByDates") + " and c_name like ?";

		return this.getJdbcTemplate().queryForObject(sql, Integer.class, "%" + keyword + "%");
	}

	public List<CourseItem> selectByMemberId(int memberId, int startNum, int endNum) {
		this.sql = query.get("selectByMemberId");
//		and sysdate between c_sdate-14 and c_edate+14""";
		this.sql = setPaging(sql, startNum, endNum);
		List<CourseItem> courseItems = this.getJdbcTemplate().query(sql, new RowMapper<CourseItem>() {
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
		this.sql = query.get("getCountByMemberId");

		return this.getJdbcTemplate().queryForObject(sql, Integer.class, memberId);
	}

	private void init() {
		this.query = new HashMap<String, String>();
		this.query.put("selectByDates",
				"""
						select fcs.course_id, c_title, c_name, c_count, c_limits, to_char(c_sdate, 'yyyy.mm.dd') c_sdate, to_char(c_edate, 'yyyy.mm.dd') c_edate
						from final_course fc
						inner join final_course_category fcc on fc.category_id = fcc.category_id
						inner join (select course_id, count(*) as c_count from final_course_student fcs group by course_id) fcs on fcs.course_id = fc.course_id
						where c_count < c_limits
						order by c_sdate, c_edate desc""");
		this.query.put("selectByMemberId", """
				select fcs.course_id, c_title, c_name
				from final_course fc
				inner join final_course_category fcc on fc.category_id = fcc.category_id
				inner join final_course_student fcs on fc.course_id = fcs.course_id
				where member_id = ? """);
		this.query.put("getCountByDates",
				"""
						select count(*) as cnt
						from final_course fc
						inner join (select course_id, count(*) as c_count from final_course_student fcs group by course_id) fcs on fcs.course_id = fc.course_id
						where c_count < c_limits""");
		this.query.put("getCountByMemberId", """
				select count(*) as cnt
				from final_course fc
				inner join final_course_student fcs on fc.course_id = fcs.course_id
				where member_id = ?""");
	}
}
