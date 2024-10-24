package com.project.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.model.CourseDO;
import com.project.model.CourseNoticeItem;
import com.project.model.CourseNoticePostItem;

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
	
	public List<CourseNoticePostItem> getAllNoticePosts() {
		
		List<CourseNoticePostItem> queryResult = this.getJdbcTemplate().query("select * from final_course_post where type_id = 1", new RowMapper<CourseNoticePostItem>() {
			@Override
			public CourseNoticePostItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseNoticePostItem noticeItems = new CourseNoticeItem();
				
				noticeItems.setCourseId(rs.getInt("course_id"));
				noticeItems.setMemberId(rs.getInt("member_id"));
				noticeItems.setNoticeContents(rs.getString("p_contents"));
				noticeItems.setNoticeTitle(rs.getString("p_title"));
				noticeItems.setPostId(rs.getInt("post_id"));
				noticeItems.setRegDate(rs.getString("p_regdate"));
				noticeItems.setStatus(rs.getInt("p_status"));
				noticeItems.setTarget(rs.getInt("p_target"));
				noticeItems.setTypeId(rs.getInt("type_id"));
				noticeItems.setAttachment(rs.getString(insertAttachment(rs.getInt("post_id"))));
				return noticeItems;
			}});

		
		return queryResult;
	}
	
	public String insertAttachment(int post_id) {
		return this.getJdbcTemplate().queryForObject("select p_attm from final_post_attm where post_id = ?", new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String attachmentName = rs.getString("post_id");
				
				return attachmentName;
			}
			
		}, post_id);
	}
	
	public CourseDO getCourseId(int userCourseId) {
		return this.getJdbcTemplate().queryForObject("select course_id from final_course where course_id = ?", new RowMapper<CourseDO>() {
			@Override
			public CourseDO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseDO courseId = new CourseDO();
				courseId.setCourse_id(rs.getInt("course_id"));
				
				return courseId;
			}
			
		}, userCourseId);
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