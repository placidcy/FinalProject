package com.project.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.model.CourseNoticeItem;

@Repository
public class CourseNoticeDAO extends C_N_ItemDAO {
	private String sql;
	private Map<String, String> query;

	public CourseNoticeDAO() {
		super();
		init();
	}

	public CourseNoticeItem selectOne(int noticeId) {
		this.sql = query.get("selectOne");
		return this.getJdbcTemplate().queryForObject(sql, new RowMapper<CourseNoticeItem>() {
			@Override
			public CourseNoticeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseNoticeItem courseNoticeItem = new CourseNoticeItem();
				courseNoticeItem.setNoticeId(rs.getInt("post_id"));
				courseNoticeItem.setNoticeTitle(rs.getString("p_title"));
				courseNoticeItem.setRegDate(rs.getString("p_regdate"));
				courseNoticeItem.setNoticeContents(rs.getString("p_contents"));
				courseNoticeItem.setAttachment(rs.getString("p_attm"));
				return courseNoticeItem;
			}
		}, noticeId);
	}

	public List<CourseNoticeItem> selectAll(int startNum, int endNum) {
		String sql = setPaging(query.get("selectAll"), startNum, endNum);
//		System.out.println("Executing SQL: " + sql); // 실행되는 SQL 로그 출력
		return this.getJdbcTemplate().query(sql, new RowMapper<CourseNoticeItem>() {
			@Override
			public CourseNoticeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseNoticeItem courseNoticeItem = new CourseNoticeItem();
				courseNoticeItem.setNoticeId(rs.getInt("post_id"));
				courseNoticeItem.setNoticeTitle(rs.getString("p_title"));
				courseNoticeItem.setRegDate(rs.getString("p_regdate"));
				courseNoticeItem.setNoticeContents(rs.getString("p_contents"));
				courseNoticeItem.setAttachment(rs.getString("p_attm"));
				return courseNoticeItem;
			}
		});
	}

//	public List<CourseNoticeItem> selectByKeyword(String keyword, int startNum, int endNum) {
//		this.sql = "select * from (" + query.get("selectAll") + ") where p_title like ? or p_contents like ?";
//		this.sql = setPaging(sql, startNum, endNum);
//		return this.getJdbcTemplate().query(sql, new RowMapper<CourseNoticeItem>() {
//			@Override
//			public CourseNoticeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
//				CourseNoticeItem courseNoticeItem = new CourseNoticeItem();
//				courseNoticeItem.setNoticeId(rs.getInt("post_id"));
//				courseNoticeItem.setNoticeTitle(rs.getString("p_title"));
//				courseNoticeItem.setRegDate(rs.getString("p_regdate"));
//				return courseNoticeItem;
//			}
//		}, "%" + keyword + "%", "%" + keyword + "%");
//	}

	public int getCount() {
		this.sql = query.get("getCount");
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

//	public int getCount(String keyword) {
//		this.sql = query.get("getCount") + " and p_title like ? or p_contents like ?";
//		return this.getJdbcTemplate().queryForObject(sql, Integer.class, "%" + keyword + "%", "%" + keyword + "%");
//	}

	private void init() {
		this.query = new HashMap<>();
		this.query.put("getCount", """
				select count(*) as cnt
				from final_course_post fcp
				where course_id=2 and type_id=1
				""");
		this.query.put("selectAll", """
				select to_char(p_regdate, 'YYYY-MM-DD') as p_regdate, p_title, p_contents, post_id,
				       (select listagg(p_attm, ', ') within group (order by p_attm)
				        from final_post_attm
				        where post_id = fcp.post_id) as p_attm
				from final_course_post fcp
				where course_id=2 and type_id=1
				order by p_regdate desc
				""");
		this.query.put("selectOne", """
				select to_char(p_regdate, 'YYYY-MM-DD HH:MI:SS') as p_regdate, p_title, p_contents, post_id,
				       (select listagg(p_attm, ', ') within group (order by p_attm)
				        from final_post_attm
				        where post_id = fcp.post_id) as p_attm
				from final_course_post fcp
				where post_id = ?
				""");
	}

}