package com.project.model.dao;

import java.sql.*;
import java.util.*;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.project.model.NoticeItem;

@Repository
public class NoticeItemDAO extends ItemDAO {
	private String sql;
	private Map<String, String> query;

	public NoticeItemDAO() {
		super();
		init();
	}

	public NoticeItem selectOne(int noticeId) {
		this.sql = query.get("selectOne");
		NoticeItem noticeItem = this.getJdbcTemplate().queryForObject(sql, new RowMapper<NoticeItem>() {
			@Override
			public NoticeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeItem noticeItem = new NoticeItem();

				noticeItem.setNoticeId(rs.getInt("post_id"));
				noticeItem.setNoticeTitle(rs.getString("p_title"));
				noticeItem.setRegdate(rs.getString("p_regdate"));
				noticeItem.setNoticeContents(rs.getString("p_contents"));
				noticeItem.setAttachments(rs.getString("p_attms"));

				return noticeItem;
			}
		}, noticeId);
		return noticeItem;
	}

	public List<NoticeItem> selectList(int startNum, int endNum) {
		this.sql = query.get("selectList");
		this.sql = setPaging(sql, startNum, endNum);
		List<NoticeItem> noticeItems = this.getJdbcTemplate().query(sql, new RowMapper<NoticeItem>() {
			@Override
			public NoticeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeItem noticeItem = new NoticeItem();

				noticeItem.setNoticeId(rs.getInt("post_id"));
				noticeItem.setNoticeTitle(rs.getString("p_title"));
				noticeItem.setRegdate(rs.getString("p_regdate"));
				noticeItem.setTarget(rs.getInt("p_target"));

				return noticeItem;
			}
		});

		return noticeItems;
	}

	public List<NoticeItem> selectAll(int startNum, int endNum) {
		this.sql = query.get("selectAll");
		this.sql = setPaging(sql, startNum, endNum);
		List<NoticeItem> noticeItems = this.getJdbcTemplate().query(sql, new RowMapper<NoticeItem>() {
			@Override
			public NoticeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeItem noticeItem = new NoticeItem();

				noticeItem.setNoticeId(rs.getInt("post_id"));
				noticeItem.setNoticeTitle(rs.getString("p_title"));
				noticeItem.setRegdate(rs.getString("p_regdate"));
				noticeItem.setTarget(rs.getInt("p_target"));

				return noticeItem;
			}
		});

		return noticeItems;
	}

	public List<NoticeItem> selectByKeyword(String keyword, int startNum, int endNum) {
		this.sql = "select * from (" + query.get("selectList") + ") where p_title like ? or p_contents like ?";
		this.sql = setPaging(sql, startNum, endNum);
		List<NoticeItem> noticeItems = this.getJdbcTemplate().query(sql, new RowMapper<NoticeItem>() {
			@Override
			public NoticeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeItem noticeItem = new NoticeItem();

				noticeItem.setNoticeId(rs.getInt("post_id"));
				noticeItem.setNoticeTitle(rs.getString("p_title"));
				noticeItem.setRegdate(rs.getString("p_regdate"));

				return noticeItem;
			}
		}, "%" + keyword + "%", "%" + keyword + "%");

		return noticeItems;
	}

	public List<NoticeItem> selectAllByKeyword(String keyword, int startNum, int endNum) {
		this.sql = "select * from (" + query.get("selectAll") + ") where p_title like ? or p_contents like ?";
		this.sql = setPaging(sql, startNum, endNum);
		List<NoticeItem> noticeItems = this.getJdbcTemplate().query(sql, new RowMapper<NoticeItem>() {
			@Override
			public NoticeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeItem noticeItem = new NoticeItem();

				noticeItem.setNoticeId(rs.getInt("post_id"));
				noticeItem.setNoticeTitle(rs.getString("p_title"));
				noticeItem.setRegdate(rs.getString("p_regdate"));

				return noticeItem;
			}
		}, "%" + keyword + "%", "%" + keyword + "%");

		return noticeItems;
	}

	public int getCount() {
		this.sql = query.get("getCount");
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int getTotalCount() {
		this.sql = query.get("getTotalCount");
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int getCount(String keyword) {
		this.sql = query.get("getCount") + "  and p_title like ? or p_contents like ?";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, "%" + keyword + "%", "%" + keyword + "%");
	}

	public int getTotalCount(String keyword) {
		this.sql = query.get("getTotalCount") + "  and p_title like ? or p_contents like ?";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, "%" + keyword + "%", "%" + keyword + "%");
	}

	public int insertNewPost(String title, String content, int target, int memberId) {
		this.sql = query.get("insertNewPost");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.getJdbcTemplate().update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, new String[] { "post_id" });
			ps.setInt(1, memberId);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setInt(4, target);
			return ps;
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	public int[] batchInsert(int postId, List<String> files) {
		String sql = this.query.get("batchInsert");

		return this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, postId);
				ps.setString(2, files.get(i));
			}

			@Override
			public int getBatchSize() {
				return files.size();
			}
		});
	}

	private void init() {
		this.query = new HashMap<String, String>();
		this.query.put("getCount", """
				select count(*) as cnt
				from final_course_post fcp
				where type_id = 0 and p_target = 0
				""");
		this.query.put("getTotalCount", """
				select count(*) as cnt
				from final_course_post
				where type_id = 0
				""");
		this.query.put("selectList", """
				select  to_char(p_regdate, 'YYYY-MM-DD') as p_regdate,
						p_title, p_contents, post_id, p_target
				from final_course_post fcp
				where type_id=0 and p_target = 0
				order by p_regdate desc
				""");
		this.query.put("selectAll", """
				select  to_char(p_regdate, 'YYYY-MM-DD') as p_regdate, p_title, p_contents, post_id, p_target
				from final_course_post fcp
				where type_id=0
				order by p_regdate desc
				""");
		this.query.put("selectOne", """
				select  to_char(p_regdate, 'YYYY-MM-DD HH:MI:SS') as p_regdate,
						p_title, p_contents, p_attms, fcp.post_id
				from final_course_post fcp left outer join (
					select post_id, LISTAGG(p_attm, ',')  WITHIN GROUP(ORDER BY p_attm) as p_attms
					from final_post_attm
					group by post_id
					) fpa on fcp.post_id = fpa.post_id
				where fcp.post_id = ?
				""");
		this.query.put("insertNewPost",
				"""
						INSERT INTO FINAL_COURSE_POST(post_id, type_id, member_id, course_id, p_title, p_contents, p_regdate, p_target, p_status)
						VALUES(seq_post_id.nextval, 0, ?, NULL, ?, ?, sysdate, ?, DEFAULT)
						""");
		this.query.put("batchInsert", """
				INSERT INTO final_post_attm VALUES (?, ?)
								""");
	}
}