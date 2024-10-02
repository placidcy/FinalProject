package com.project.model.dao;

import java.sql.*;
import java.util.*;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.model.NoticeItem;

@Repository
public class NoticeDAO extends ItemDAO {
	private String sql;
	private Map<String, String> query;

	public NoticeDAO() {
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
				noticeItem.setAttachments(rs.getArray("p_attms"));

				return noticeItem;
			}
		}, noticeId);
		return noticeItem;
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

				return noticeItem;
			}
		});

		return noticeItems;
	}

	public List<NoticeItem> selectByKeyword(String keyword, int startNum, int endNum) {
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

	public int getCount(String keyword) {
		this.sql = query.get("getCount") + "  and p_title like ? or p_contents like ?";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, "%" + keyword + "%", "%" + keyword + "%");
	}

	private void init() {
		this.query = new HashMap<String, String>();
		this.query.put("getCount", """
				select count(*) as cnt
				from final_course_post fcp
				where type_id = 0 and p_target = 0
				""");
		this.query.put("selectAll", """
				select  to_char(p_regdate, 'YYYY-MM-DD') as p_regdate, p_title, p_contents, post_id
				from final_course_post fcp
				where type_id=0 and p_target = 0
				order by p_regdate desc
				""");
		this.query.put("selectOne",
				"""
						select  to_char(p_regdate, 'YYYY-MM-DD HH:MI:SS') as p_regdate, p_title, p_contents, p_attms, fcp.post_id
						from final_course_post fcp left outer join (
							select post_id, LISTAGG(p_attm, ',')  WITHIN GROUP(ORDER BY p_attm) as p_attms
							from final_post_attm
							group by post_id
						) fpa on fcp.post_id = fpa.post_id
						where fcp.post_id = ?
						""");
	}
}