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

	/*
	 * memberId에 따라 현재 요일에 수강해야하는 강의 목록을 조회하는 쿼리
	 */
	public int checkCourse(int memberId) {
		int courseId = -1;
		this.sql = query.get("checkCourse");

		courseId = this.getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("course_id");
			}
		}, memberId);
		return courseId;
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

	public CourseItem getInfo(int courseId) {
		this.sql = query.get("getInfo");
		CourseItem courseItem = this.getJdbcTemplate().queryForObject(sql, new RowMapper<CourseItem>() {
			@Override
			public CourseItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseItem courseItem = new CourseItem();
				courseItem.setCategoryName(rs.getString("c_title"));
				courseItem.setCourseId(rs.getInt("course_id"));
				courseItem.setCourseName(rs.getString("c_name"));
				courseItem.setdDay(rs.getInt("c_dday"));
				courseItem.setStartDate(rs.getString("c_sdate"));
				courseItem.setEndDate(rs.getString("c_edate"));
				courseItem.setInstList(rs.getString("c_ilist"));
				courseItem.setQrCode(rs.getString("q_code"));
				courseItem.setQrRegdate(rs.getString("q_regdate"));
				courseItem.setQrEffdate(rs.getString("q_effdate"));

				return courseItem;
			}
		}, courseId);

		return courseItem;
	}

	private void init() {
		this.query = new HashMap<String, String>();
		/*
		 * 수강 신청 목록 조횤 쿼리 - 날짜 조건 제외 (2024.10.04)
		 */
		this.query.put("selectByDates",
				"""
						select fcs.course_id, c_title, c_name, c_count, c_limits, to_char(c_sdate, 'yyyy.mm.dd') c_sdate, to_char(c_edate, 'yyyy.mm.dd') c_edate
						from final_course fc
						inner join final_course_category fcc on fc.category_id = fcc.category_id
						inner join (select course_id, count(*) as c_count from final_course_student fcs group by course_id) fcs on fcs.course_id = fc.course_id
						where c_count < c_limits
						order by c_sdate, c_edate desc""");
		/*
		 * 수강 중인 강의 목록 조회 쿼리 - 날짜 조건 제외 (2024.10.04)
		 */
		this.query.put("selectByMemberId", """
				select fcs.course_id, c_title, c_name
				from final_course fc
				inner join final_course_category fcc on fc.category_id = fcc.category_id
				inner join final_course_student fcs on fc.course_id = fcs.course_id
				where member_id = ? """);
		/*
		 * 수강 신청 목록 총 갯수 반환 쿼리 - 날짜 조건 제외 (2024.10.04)
		 */
		this.query.put("getCountByDates",
				"""
						select count(*) as cnt
						from final_course fc
						inner join (select course_id, count(*) as c_count from final_course_student fcs group by course_id) fcs on fcs.course_id = fc.course_id
						where c_count < c_limits""");
		/*
		 * 수강 중인 강의 목록 총 갯수 반환 쿼리 - 날짜 조건 제외 (2024.10.04)
		 */
		this.query.put("getCountByMemberId", """
				select count(*) as cnt
				from final_course fc
				inner join final_course_student fcs on fc.course_id = fcs.course_id
				where member_id = ?""");
		/*
		 * 수강 중인 강의 중 현재 요일에 해당하는 강의가 있는지 확인하는 코드
		 */
		this.query.put("checkCourse", """
				SELECT *
				FROM ( SELECT fcs.MEMBER_ID , fc.COURSE_ID, fc.C_NAME,
						CASE
							WHEN TO_CHAR(SYSDATE, 'D') = 2
							AND fcd.D_MON = 1 THEN 1
							WHEN TO_CHAR(SYSDATE, 'D') = 3
							AND fcd.D_TUE = 1 THEN 1
							WHEN TO_CHAR(SYSDATE, 'D') = 4
							AND fcd.D_WED = 1 THEN 1
							WHEN TO_CHAR(SYSDATE, 'D') = 5
							AND fcd.D_THU = 1 THEN 1
							WHEN TO_CHAR(SYSDATE, 'D') = 6
							AND fcd.D_FRI = 1 THEN 1
							WHEN TO_CHAR(SYSDATE, 'D') = 7
							AND fcd.D_SAT = 1 THEN 1
							WHEN TO_CHAR(SYSDATE, 'D') = 1
							AND fcd.D_SUN = 1 THEN 1
							ELSE 0
						END AS C_RESULT
					FROM FINAL_COURSE fc
					INNER JOIN FINAL_COURSE_DAY fcd ON fc.COURSE_ID = fcd.COURSE_ID
					INNER JOIN FINAL_COURSE_STUDENT fcs ON fc.COURSE_ID = fcs.COURSE_ID)
				WHERE c_result = 1 AND member_id = ?""");
		/*
		 * 강의 정보를 불러오는 쿼리문 - 현재 시간에 유효한 QR코드가 존재하는지 체크하는 구문 제외
		 */
		this.query.put("getInfo", """
				SELECT
					fc.*,
					q_code,
					to_char(q_regdate, 'yyyy-mm-dd hh24:mi:ss') q_regdate,
					to_char(q_regdate + q_efftime/24/60, 'yyyy-mm-dd hh24:mi:ss') q_effdate
				FROM
					(
					SELECT
						fc.course_id,
						c_title,
						c_name,
						TO_CHAR(c_sdate, 'yyyy.mm.dd') c_sdate,
						TO_CHAR(c_edate, 'yyyy.mm.dd') c_edate,
						LISTAGG(m_name, ', ') WITHIN GROUP (
					ORDER BY
						m_name) AS c_ilist,
						trunc(c_edate) - trunc(sysdate) AS c_dday
					FROM
						FINAL_COURSE fc
					INNER JOIN FINAL_COURSE_INSTRUCTOR fci ON
						fc.COURSE_ID = fci.COURSE_ID
					INNER JOIN FINAL_COURSE_CATEGORY fcc ON
						fc.CATEGORY_ID = fcc.CATEGORY_ID
					INNER JOIN FINAL_MEMBER fm ON
						fm.MEMBER_ID = fci.MEMBER_ID
					WHERE
						fc.COURSE_ID = ?
					GROUP BY
						fc.course_id,
						c_title,
						c_name,
						TO_CHAR(c_sdate, 'yyyy.mm.dd'),
						TO_CHAR(c_edate, 'yyyy.mm.dd'),
						trunc(c_edate) - trunc(sysdate)
					) fc
				LEFT OUTER JOIN FINAL_COURSE_QR fcq ON
					fc.course_id = fcq.course_id
								""");
	}
}