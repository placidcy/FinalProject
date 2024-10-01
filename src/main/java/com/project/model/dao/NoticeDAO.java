package com.project.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.model.NoticeItem;

@Repository
public class NoticeDAO extends ItemDAO {
	private String sqlString;

	public NoticeDAO() {
		super();
	}

	public List<NoticeItem> selecNoticeItems(int startNum, int endNum) {
		this.sqlString = """
				select  to_char(p_regdate, 'YYYY-MM-DD HH:MI:SS') as p_regdate, p_title, p_contents, post_id
				from final_course_post fcp
				where type_id=0 and p_target = 0
				order by p_regdate desc
				""";
		this.sqlString = setPaging(sqlString, startNum, endNum);
		List<NoticeItem> noticeItems = this.getJdbcTemplate().query(sqlString, new RowMapper<NoticeItem>() {
			@Override
			public NoticeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeItem noticeItem = new NoticeItem();

				noticeItem.setNoticeId(rs.getInt("post_id"));
				noticeItem.setNoticeTitle(rs.getString("p_title"));

				return noticeItem;
			}
		});

		return noticeItems;
	}

	public int getCount() {
		this.sqlString = """
				select count(*) as cnt
				from final_course_post fcp
				where type_id = 0 and p_target = 0
				""";
		return this.getJdbcTemplate().queryForObject(sqlString, Integer.class);
	}
}
