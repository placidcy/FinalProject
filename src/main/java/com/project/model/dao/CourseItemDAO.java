package com.project.model.dao;

import java.sql.*;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.model.*;

@Repository
public class CourseItemDAO extends ItemDAO {
	private String sql;
	private Map<String, String> query;

	public CourseItemDAO() {
		super();
		init();
	}

	public int register(int courseId, int memberId) {
		this.sql = query.get("register");
		int rowNum = -1;

		rowNum = this.getJdbcTemplate().update(sql, new Object[] { courseId, memberId });

		return rowNum;
	}

	public int checkAlreadyRegistered(int courseId, int memberId) {
		this.sql = query.get("checkAlreadyRegistered");
		int rowNum = -1;

		rowNum = this.getJdbcTemplate().queryForObject(sql, Integer.class, new Object[] { courseId, memberId });

		return rowNum;
	}

	public int checkCourseConflicts(int memberId, int courseId) {
		this.sql = query.get("checkCourseConflicts");
		int rowNum = -1;

		rowNum = this.getJdbcTemplate().queryForObject(sql, Integer.class,
				new Object[] { courseId, courseId, memberId });

		return rowNum;
	}

	public List<CourseItem> selectByDates(int startNum, int endNum, int memberId) {
		this.sql = query.get("selectByDates");
		this.sql = setPaging(sql, startNum, endNum);

		List<CourseItem> courseItems = null;
		courseItems = this.getJdbcTemplate().query(sql, new RowMapper<CourseItem>() {
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
		}, memberId);
		return courseItems;
	}

	public List<CourseItem> selectByDates(String keyword, int startNum, int endNum, int memberId) {
		this.sql = "select * from (" + query.get("selectByDates") + ") where c_name like ?";
		this.sql = setPaging(sql, startNum, endNum);

		List<CourseItem> courseItems = null;
		courseItems = this.getJdbcTemplate().query(sql, new RowMapper<CourseItem>() {
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
		}, memberId, "%" + keyword + "%");

		return courseItems;
	}

	public int getCountByDates(int memberId) {
		this.sql = this.getCount(this.query.get("selectByDates"));
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, memberId);
	}

	public int getCountByDates(String keyword, int memberId) {
		this.sql = "select * from (" + query.get("selectByDates") + ") where c_name like ?";
		this.sql = this.getCount(this.sql);

		return this.getJdbcTemplate().queryForObject(sql, Integer.class, "%" + keyword + "%");
	}

	public List<CourseItem> selectByMemberId(int memberId, int startNum, int endNum) {
		this.sql = query.get("selectByMemberId");
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

	public List<CourseItem> selectByInstructorId(int memberId, int startNum, int endNum) {
		this.sql = query.get("selectByInstructorId");
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
		this.sql = query.get("selectByMemberId");
		this.sql = this.getCount(sql);

		return this.getJdbcTemplate().queryForObject(sql, Integer.class, memberId);
	}

	public int getCountByInstructorId(int memberId) {
		this.sql = query.get("selectByInstructorId");
		this.sql = this.getCount(sql);

		return this.getJdbcTemplate().queryForObject(sql, Integer.class, memberId);
	}

	/*
	 * memberId에 따라 현재 요일에 수강해야하는 강의 목록을 조회하는 쿼리
	 */
	public int checkCourseForStudentId(int memberId) {
		int studentId = -1;
		this.sql = query.get("checkCourseForStudentId");

		studentId = this.getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("student_id");
			}
		}, memberId);
		return studentId;
	}

	/*
	 * memberId에 따라 현재 요일에 수업해야하는 강의 목록을 조회하는 쿼리
	 */
	public int checkCourseForCourseId(int memberId) {
		int courseId = -1;
		this.sql = query.get("checkCourseForCourseId");

		courseId = this.getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("course_id");
			}
		}, memberId);
		return courseId;
	}

	public int createQR(int courseId, String qrCode) {
		this.sql = query.get("createQR");
		int rowNum = this.getJdbcTemplate().update(sql, courseId, qrCode);

		return rowNum;
	}

	public CourseItem getInfoByStudentId(int studentId) {
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

				return courseItem;
			}
		}, studentId);

		return courseItem;
	}

	public CourseItem getInfoByCourseId(int courseId) {
		this.sql = query.get("getInfoByCourseId");
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

				return courseItem;
			}
		}, courseId);

		return courseItem;
	}

	public Timetable getTimetable(int studentId) {
		this.sql = query.get("getTimetable");
		Timetable timetable = null;

		try {
			timetable = this.getJdbcTemplate().queryForObject(sql, new RowMapper<Timetable>() {
				@Override
				public Timetable mapRow(ResultSet rs, int rowNum) throws SQLException {
					Timetable timetable = new Timetable();

					timetable.setCinTime(rs.getString("a_cintime"));
					timetable.setCoutTime(rs.getString("a_couttime"));
					timetable.setRetTime(rs.getString("a_rettime"));
					timetable.setSoutTime(rs.getString("a_souttime"));

					return timetable;
				}
			}, studentId);
		} catch (Exception e) {
			/* 만일 출결 정보를 조회할 수 없다면(금일 출결 데이터가 생성되지 않은 경우) */
			this.sql = query.get("setTimetable");
			this.getJdbcTemplate().update(sql, studentId);
		}

		return timetable;
	}

	public int isQRValid(String code, int studentId) {
		this.sql = query.get("isQRValid");
		int rowNum = -1;

		rowNum = this.getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("is_valid");
			}
		}, code, studentId);

		return rowNum;
	}

	public CourseItem getQrCode(int courseId, CourseItem courseItem) {
		this.sql = query.get("getQrCode");
		CourseItem qrData = null;

		try {
			qrData = this.getJdbcTemplate().queryForObject(sql, new RowMapper<CourseItem>() {
				@Override
				public CourseItem mapRow(ResultSet rs, int rowNum) throws SQLException {
					CourseItem courseItem = new CourseItem();

					courseItem.setQrCode(rs.getString("q_code"));
					courseItem.setQrRegdate(rs.getString("q_regdate"));
					courseItem.setQrEfftime(rs.getInt("q_efftime"));

					return courseItem;
				}
			}, courseId);

			courseItem.setQrCode(qrData.getQrCode());
			courseItem.setQrRegdate(qrData.getQrRegdate());
			courseItem.setQrEfftime(qrData.getQrEfftime());
		} catch (Exception e) {
			System.out.println("예외: 현재 유효한 QR코드 없음");
		}

		return courseItem;
	}

	public int updateTimetable(String updateKey, int studentId) {
		this.sql = query.get(updateKey);
		int rowNum = -1;

		rowNum = this.getJdbcTemplate().update(sql, studentId);

		return rowNum;
	}

	public StatsItem getStats(int studentId) {
		this.sql = query.get("getStats");
		StatsItem statsItem = null;

		statsItem = this.getJdbcTemplate().queryForObject(sql, new RowMapper<StatsItem>() {
			@Override
			public StatsItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				StatsItem statsItem = new StatsItem();
				statsItem.setPresentCnt(rs.getInt("출석"));
				statsItem.setTardyCnt(rs.getInt("지각"));
				statsItem.setLeaveCnt(rs.getInt("조퇴"));
				statsItem.setAbsentCnt(rs.getInt("결석"));
				statsItem.setTotalCnt(rs.getInt("total_count"));
				statsItem.setAvgCnt(rs.getInt("avg_count"));
				statsItem.setMyCnt(rs.getInt("student_count"));

				return statsItem;
			}
		}, studentId);

		return statsItem;
	}

	public StatsItem getStatsByCourseId(int courseId) {
		this.sql = query.get("getStatsByCourseId");
		StatsItem statsItem = null;

		statsItem = this.getJdbcTemplate().queryForObject(sql, new RowMapper<StatsItem>() {
			@Override
			public StatsItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				StatsItem statsItem = new StatsItem();
				statsItem.setPresentCnt(rs.getInt("출석"));
				statsItem.setTardyCnt(rs.getInt("지각"));
				statsItem.setLeaveCnt(rs.getInt("조퇴"));
				statsItem.setAbsentCnt(rs.getInt("결석"));
				statsItem.setTotalCnt(rs.getInt("total_count"));
				statsItem.setAvgCnt(rs.getInt("avg_count"));
				statsItem.setMyCnt(rs.getInt("today_count"));

				return statsItem;
			}
		}, courseId);

		return statsItem;
	}

	public int checkAttendStatus(int courseId) {
		this.sql = query.get("checkAttendStatus");

		return this.getJdbcTemplate().queryForObject(sql, Integer.class, courseId);
	}

	public void initAttendance(int courseId) {
		this.sql = query.get("initAttendance");

		try {
			this.getJdbcTemplate().update(sql, courseId);
		} catch (Exception e) {
			System.out.println("출석 데이터 초기화 실패");
		}
	}

	public int insertDailyRecords() {
		this.sql = query.get("insertDailyRecords");
		return this.getJdbcTemplate().update(sql, Integer.class);
	}

	public int updateDailyRecords() {
		this.sql = query.get("updateDailyRecords");
		return this.getJdbcTemplate().update(sql, Integer.class);
	}

	public String getCount(String sql) {
		return "select count(*) from (" + sql + ")";
	}

	private void init() {
		this.query = new HashMap<String, String>();
		/*
		 * 수강 신청 목록 조횤 쿼리
		 */
		this.query.put("selectByDates", """
				SELECT DISTINCT fcs.course_id, c_title, c_name, c_count, c_limits,
				                TO_CHAR(c_sdate, 'yyyy.mm.dd') AS c_sdate,
				                TO_CHAR(c_edate, 'yyyy.mm.dd') AS c_edate
				FROM final_course fc
				INNER JOIN final_course_category fcc ON fc.category_id = fcc.category_id
				INNER JOIN (
				    SELECT course_id, COUNT(*) AS c_count
				    FROM final_course_student
				    GROUP BY course_id
				) fcs ON fcs.course_id = fc.course_id
				WHERE c_count < c_limits
				  AND SYSDATE BETWEEN c_sdate - 28 AND c_sdate - 1
				  AND fc.COURSE_ID NOT IN (SELECT COURSE_ID FROM FINAL_COURSE_STUDENT fcs WHERE member_id = ?)
				ORDER BY c_sdate, c_edate
								""");
		/*
		 * 수강 중인 강의 목록 조회 쿼리
		 */
		this.query.put("selectByMemberId", """
				select
				  fcs.course_id,
				  c_title,
				  c_name
				from
				  final_course fc
				  inner join final_course_category fcc on fc.category_id = fcc.category_id
				  inner join final_course_student fcs on fc.course_id = fcs.course_id
				where
				  member_id = ?
				  and sysdate between c_sdate-14 and c_edate+14
				 """);
		/*
		 * 담당 중인 강의 목록 조회
		 */
		this.query.put("selectByInstructorId", """
				select
					fc.course_id,
					c_title,
					c_name
				from
					final_course fc
					inner join final_course_category fcc on fc.category_id = fcc.category_id
					inner join final_course_instructor fci on fc.course_id = fci.course_id
				where
					member_id = ?
					and sysdate between c_sdate-14 and c_edate+14
				""");

		/*
		 * 수강 신청 목록 총 갯수 반환 쿼리
		 */
		this.query.put("getCountByDates", """
				select
				  count(*) as cnt
				from
				  final_course fc
				  inner join (
				    select
				      course_id,
				      count(*) as c_count
				    from
				      final_course_student fcs
				    group by
				      course_id
				  ) fcs on fcs.course_id = fc.course_id
				where
				  c_count < c_limits
				-- 현재일이 강의 시작일 및 종료일로 부터 2주 내외로 존재하는지 확인하는 구문
				-- 테스트를 위해 주석 처리
				-- and sysdate between c_sdate-14 and c_edate+14
				""");
		/*
		 * 학생으로 로그인했을 때, 수강 중인 강의 목록 총 갯수 반환 쿼리
		 */
		this.query.put("getCountByMemberId", """
				select
				  count(*) as cnt
				from
				  final_course fc
				  inner join final_course_student fcs on fc.course_id = fcs.course_id
				where
				  member_id = ?
				  and sysdate between c_sdate-14 and c_edate+14
				""");
		/*
		 * 강사로 로그인하였을 때, 담당 중인 강의 목록 총 갯수 반환 쿼리
		 */
		this.query.put("getCountByInstructorId", """
				select
					count(*) as cnt
				from
					final_course fc
					inner join final_course_instructor fci on fc.course_id = fci.course_id
				where
				  	member_id = ?
				  	and sysdate between c_sdate-14 and c_edate+14
				""");

		/*
		 * 수강 중인 강의 중 현재 요일에 해당하는 강의가 있는지 확인하는 쿼리
		 */
		this.query.put("checkCourseForStudentId",
				"""
						SELECT student_id
						FROM (
						    SELECT fcs.*, fc.C_NAME, fct.COURSE_ID, fcs2.S_SDATE, fcs2.S_STIME, fcs2.S_EDATE, fcs2.S_ETIME
						    FROM FINAL_COURSE_STUDENT fcs
						    INNER JOIN FINAL_COURSE_TODAY fct ON fcs.COURSE_ID = fct.COURSE_ID
						    INNER JOIN FINAL_COURSE fc ON fc.course_id = fcs.course_id
						    INNER JOIN final_course_schedule fcs2 ON fcs.course_id = fcs2.course_id
						        AND SYSDATE BETWEEN TO_DATE(TO_CHAR(fcs2.S_SDATE, 'yyyy-mm-dd') || ' ' || fcs2.S_STIME, 'yyyy-mm-dd hh24:mi:ss')
						                         AND TO_DATE(TO_CHAR(fcs2.S_EDATE, 'yyyy-mm-dd') || ' ' || fcs2.S_ETIME, 'yyyy-mm-dd hh24:mi:ss')
						                         -- 현재 시간대에 속한 강의를 조회
						)
						WHERE member_id = ? and rownum = 1
						""");
		/*
		 * 수업 중인 강의 중 현재 요일에 해당하는 강의가 있는지 확인하는 쿼리(강사용)
		 */
		this.query.put("checkCourseForCourseId",
				"""
								SELECT course_id
								FROM (
								    SELECT fcs.*, fc.C_NAME, fcs2.S_SDATE, fcs2.S_STIME, fcs2.S_EDATE, fcs2.S_ETIME
								    FROM FINAL_COURSE_INSTRUCTOR fcs
								    INNER JOIN FINAL_COURSE_TODAY fct ON fcs.COURSE_ID = fct.COURSE_ID
								    INNER JOIN FINAL_COURSE fc ON fc.course_id = fcs.course_id
								    INNER JOIN final_course_schedule fcs2 ON fcs.course_id = fcs2.course_id
								    WHERE SYSDATE BETWEEN TO_DATE(TO_CHAR(fcs2.S_SDATE, 'yyyy-mm-dd') || ' ' || fcs2.S_STIME, 'yyyy-mm-dd hh24:mi:ss')
								                     AND TO_DATE(TO_CHAR(fcs2.S_EDATE, 'yyyy-mm-dd') || ' ' || fcs2.S_ETIME, 'yyyy-mm-dd hh24:mi:ss')
								)
								WHERE MEMBER_ID = ? AND ROWNUM = 1
						""");
		/*
		 * 현재일의 입실/퇴실/외출/복귀 시간을 조회하는 쿼리
		 */
		this.query.put("getTimetable", """
				SELECT
				  to_char(a_cintime, 'hh24:mi') as a_cintime,
				  to_char(a_couttime, 'hh24:mi') as a_couttime,
				  to_char(a_souttime, 'hh24:mi') as a_souttime,
				  to_char(a_rettime, 'hh24:mi') as a_rettime
				FROM
				  FINAL_STUDENT_ATTEND fsa
				WHERE
				  STUDENT_ID = ?
				  AND A_DATE = trunc(sysdate)
				  """);

		/* 금일 타임테이블이 존재하지 않으면 새로운 행을 추가하는 쿼리 */
		this.query.put("setTimetable", """
				INSERT INTO FINAL_STUDENT_ATTEND fsa
				VALUES
				  (
				    ?,
				    trunc(sysdate),
				    NULL,
				    NULL,
				    NULL,
				    NULL,
				    DEFAULT
				  )
				  """);

		/* 조건에 따라 출결시간 정보를 갱신하는 쿼리 */
		this.query.put("setCheckin", """
				UPDATE
				  FINAL_STUDENT_ATTEND
				SET
				  a_cintime = sysdate
				WHERE
				  STUDENT_ID = ?
				  AND A_DATE = TRUNC(SYSDATE)
				  AND a_cintime is null
				  """);

		this.query.put("setCheckout", """
				UPDATE
				  FINAL_STUDENT_ATTEND
				SET
				  a_couttime = sysdate
				WHERE
				  STUDENT_ID = ?
				  AND A_DATE = TRUNC(SYSDATE)
				  AND a_cintime is not null
				""");

		this.query.put("setStepout", """
				UPDATE
				  FINAL_STUDENT_ATTEND
				SET
				  a_souttime = sysdate
				WHERE
				  STUDENT_ID = ?
				  AND A_DATE = TRUNC(SYSDATE)
				  AND a_cintime is not null
				  AND a_couttime is null
				""");
		this.query.put("setReturn", """
				UPDATE
				  FINAL_STUDENT_ATTEND
				SET
				  a_rettime = sysdate
				WHERE
				  STUDENT_ID = ?
				  AND A_DATE = TRUNC(SYSDATE)
				  AND a_souttime is not null
				  AND a_couttime is null
				""");

		/*
		 * 강의 정보를 불러오는 쿼리문
		 */
		this.query.put("getInfo", """
				SELECT
				  fc.course_id,
				  c_title,
				  c_name,
				  TO_CHAR(c_sdate, 'yyyy.mm.dd') c_sdate,
				  TO_CHAR(c_edate, 'yyyy.mm.dd') c_edate,
				  LISTAGG(m_name, ', ') WITHIN GROUP (
				    ORDER BY
				      m_name
				  ) AS c_ilist,
				  trunc(c_edate) - trunc(sysdate) AS c_dday
				FROM
				  FINAL_COURSE fc
				  INNER JOIN FINAL_COURSE_INSTRUCTOR fci ON fc.COURSE_ID = fci.COURSE_ID
				  INNER JOIN FINAL_COURSE_CATEGORY fcc ON fc.CATEGORY_ID = fcc.CATEGORY_ID
				  INNER JOIN FINAL_MEMBER fm ON fm.MEMBER_ID = fci.MEMBER_ID
				  INNER JOIN FINAL_COURSE_STUDENT fcs ON fcs.course_id = fc.course_id
				WHERE
				  fcs.student_id = ?
				GROUP BY
				  fc.course_id,
				  c_title,
				  c_name,
				  TO_CHAR(c_sdate, 'yyyy.mm.dd'),
				  TO_CHAR(c_edate, 'yyyy.mm.dd'),
				  trunc(c_edate) - trunc(sysdate)
				  """);
		/*
		 * 강의 정보를 불러오는 쿼리문(강사용)
		 */
		this.query.put("getInfoByCourseId", """
				SELECT
				  fc.course_id,
				  c_title,
				  c_name,
				  TO_CHAR(c_sdate, 'yyyy.mm.dd') c_sdate,
				  TO_CHAR(c_edate, 'yyyy.mm.dd') c_edate,
				  LISTAGG(m_name, ', ') WITHIN GROUP (
				    ORDER BY
				      m_name
				  ) AS c_ilist,
				  trunc(c_edate) - trunc(sysdate) AS c_dday
				FROM
				  FINAL_COURSE fc
				  INNER JOIN FINAL_COURSE_INSTRUCTOR fci ON fc.COURSE_ID = fci.COURSE_ID
				  INNER JOIN FINAL_COURSE_CATEGORY fcc ON fc.CATEGORY_ID = fcc.CATEGORY_ID
				  INNER JOIN FINAL_MEMBER fm ON fm.MEMBER_ID = fci.MEMBER_ID
				WHERE
				  fc.course_id = ?
				GROUP BY
				  fc.course_id,
				  c_title,
				  c_name,
				  TO_CHAR(c_sdate, 'yyyy.mm.dd'),
				  TO_CHAR(c_edate, 'yyyy.mm.dd'),
				  trunc(c_edate) - trunc(sysdate)
				  """);
		/*
		 * 어제까지의 강의 출석 내역(출석/지각/조퇴/결석 등)을 조회하는 쿼리문
		 */
		this.query.put("getStats",
				"""
						SELECT
						  c1.*,
						  nvl (c2.출석, 0) as "출석",
						  nvl (c2.결석, 0) as "결석",
						  nvl (c2.지각, 0) as "지각",
						  nvl (c2.조퇴, 0) as "조퇴"
						FROM
						  (
						    SELECT
						      fcs.*,
						      avg(student_count) avg_count
						    FROM
						      (
						        SELECT
						          fc.course_id,
						          fcs.student_id,
						          trunc ((c_edate - c_sdate) / 7 * total_sum) AS total_count,
						          nvl (student_count, 0) AS student_count
						        FROM
						          FINAL_COURSE fc
						          INNER JOIN (
						            -- 전체 출석일수 조회
						            SELECT
						              course_id,
						              SUM(
						                NVL (D_MON, 0) + NVL (D_TUE, 0) + NVL (D_WED, 0) + NVL (D_THU, 0) + NVL (D_FRI, 0) + NVL (D_SAT, 0) + NVL (D_SUN, 0)
						              ) AS total_sum
						            FROM
						              final_course_day
						            GROUP BY
						              COURSE_ID
						          ) fcd ON fcd.course_id = fc.COURSE_ID
						          INNER JOIN FINAL_COURSE_STUDENT fcs ON fc.COURSE_ID = fcs.COURSE_ID
						          LEFT OUTER JOIN (
						            -- 나의 출석일수 조회
						            SELECT
						              student_id,
						              count(student_id) AS student_count
						            FROM
						              FINAL_STUDENT_ATTEND fsa
						            WHERE
						              -- 어제까지의 출석현황을 조회
						              a_status != 2
						              and a_date < trunc (sysdate)
						            GROUP BY
						              student_id
						          ) fsa ON fsa.student_id = fcs.STUDENT_ID
						      ) fcs
						    GROUP BY
						      (course_id, student_id, total_count, student_count)
						  ) c1
						  LEFT OUTER JOIN (
						    -- 출석/결석/지각/조퇴일수를 한번에 조회하는 쿼리
						    SELECT
						      *
						    FROM
						      (
						        SELECT
						          fsa.student_id,
						          a_status
						        FROM
						          final_student_attend fsa
						          INNER JOIN FINAL_COURSE_STUDENT fcs ON fsa.student_id = fcs.student_id
						          INNER JOIN FINAL_COURSE fc ON fc.course_id = fcs.course_id
						      ) pivot (
						        count(a_status) FOR a_status IN (1 AS "출석", 2 AS "결석", 3 "지각", 4 "조퇴")
						      )
						  ) c2 ON c1.student_id = c2.student_id
						  WHERE c1.student_id = ?
												  """);
		this.query.put("getStatsByCourseId",
				"""
						WITH stats AS (
						    SELECT *
						    FROM (
						        SELECT
						            fcs.course_id,
						            a_status
						        FROM final_student_attend fsa
						        INNER JOIN final_course_student fcs ON fcs.student_id = fsa.student_id
						        INNER JOIN final_course fc ON fc.course_id = fcs.course_id
						        WHERE a_date BETWEEN fc.c_sdate AND TRUNC(SYSDATE - 1)
						    )
						    PIVOT (
						        COUNT(a_status) FOR a_status IN (1 AS "출석", 2 AS "결석", 3 AS "지각", 4 AS "조퇴")
						    )
						),
						cnt AS (
						    SELECT
						        fst.*,
						        fcs.total_count
						    FROM (
						        SELECT
						            fcs.course_id,
						            fsa.a_date,
						            COUNT(CASE WHEN fsa.a_status <> 2 and fsa.a_cintime is not null THEN fsa.student_id END) AS today_count,
						            TRUNC(AVG(COUNT(CASE WHEN fsa.a_status NOT IN (0, 2) THEN fsa.student_id END)) OVER (PARTITION BY fcs.course_id)) AS avg_count
						        FROM final_course_student fcs
						        LEFT JOIN final_student_attend fsa ON fcs.student_id = fsa.student_id
						        GROUP BY fcs.course_id, fsa.a_date
						        ORDER BY fcs.course_id, fsa.a_date
						    ) fst
						    INNER JOIN (
						        SELECT
						            course_id,
						            COUNT(student_id) AS total_count
						        FROM final_course_student
						        GROUP BY course_id
						    ) fcs ON fst.course_id = fcs.course_id
						)
						SELECT stats.*, a_date, total_count, avg_count, today_count
						FROM stats
						INNER JOIN cnt ON stats.course_id = cnt.course_id
						WHERE stats.course_id = ? AND a_date = trunc(sysdate)
										""");
		this.query.put("createQR", """
				insert into final_course_qr
				values(?, sysdate, ?, default)
				""");

		this.query.put("isQRValid", """
				SELECT
					count(*) AS is_valid
				FROM
					FINAL_COURSE_QR fcq
				INNER JOIN FINAL_COURSE_STUDENT fcs ON
					fcq.COURSE_ID = fcs.COURSE_ID
				WHERE
					fcq.Q_CODE = ? AND fcs.STUDENT_ID = ?
					AND sysdate BETWEEN fcq.Q_REGDATE AND fcq.Q_REGDATE + NUMTODSINTERVAL(fcq.Q_EFFTIME, 'MINUTE')
					""");

		this.query.put("getQrCode", """
				SELECT
					q_code,
					to_char(q_regdate, 'yyyy-mm-dd hh24:mi:ss') q_regdate,
					q_efftime
				FROM
					FINAL_COURSE_QR fcq
				WHERE
					course_id = ?
					AND sysdate BETWEEN fcq.Q_REGDATE AND fcq.Q_REGDATE + NUMTODSINTERVAL(fcq.Q_EFFTIME, 'MINUTE')
				""");
		this.query.put("checkCourseConflicts", """
				SELECT DISTINCT count(fcs.COURSE_ID)
				FROM final_course_student fcs
				JOIN final_course_schedule fsch1 ON fcs.COURSE_ID = fsch1.COURSE_ID
				JOIN final_course_schedule fsch2 ON fsch2.COURSE_ID = ?
				JOIN final_course_day fcd1 ON fcd1.COURSE_ID = fsch1.COURSE_ID
				JOIN final_course_day fcd2 ON fcd2.COURSE_ID = ?
				WHERE fcs.MEMBER_ID = ?
				  AND (fsch1.s_stime < fsch2.s_etime AND fsch1.s_etime > fsch2.s_stime)
				  AND (fsch1.s_sdate <= fsch2.s_edate AND fsch1.s_edate >= fsch2.s_sdate)
				  AND (
				    (fcd1.D_MON = 1 AND fcd2.D_MON = 1) OR
				    (fcd1.D_TUE = 1 AND fcd2.D_TUE = 1) OR
				    (fcd1.D_WED = 1 AND fcd2.D_WED = 1) OR
				    (fcd1.D_THU = 1 AND fcd2.D_THU = 1) OR
				    (fcd1.D_FRI = 1 AND fcd2.D_FRI = 1) OR
				    (fcd1.D_SAT = 1 AND fcd2.D_SAT = 1) OR
				    (fcd1.D_SUN = 1 AND fcd2.D_SUN = 1)
				  )
				  """);
		this.query.put("register", """
				INSERT INTO FINAL_COURSE_REGISTER fcr
				VALUES (?, ?, sysdate, default)
				""");

		this.query.put("checkAlreadyRegistered", """
				SELECT count(*)
				FROM FINAL_COURSE_REGISTER fcr
				WHERE fcr.COURSE_ID = ? AND fcr.MEMBER_ID = ? AND fcr.C_REGSTATUS = 0
				""");
		this.query.put("checkAttendStatus", """
				SELECT
					count(fcs.student_id)
				FROM
					final_course_student fcs
				INNER JOIN FINAL_STUDENT_ATTEND fsa ON
					fcs.student_id = fsa.student_id
				WHERE
					course_id = ? AND a_date = trunc(sysdate)
					""");
		this.query.put("initAttendance", """
				insert into final_student_attend(student_id, a_date, a_status)
				select student_id, trunc(sysdate) a_date, '0' as a_status
				from final_course_student
				where course_id = ?
				and student_id not in (select student_id from final_student_attend where a_date = trunc(sysdate))
				""");

		/* PL/SQL 대신 CRON을 이용하여 정오마다 실행되는 프로시져 */
		this.query.put("updateDailyRecords", """
				UPDATE final_student_attend
				SET a_status =
				  CASE
				    WHEN (student_id, a_date) in (
				      SELECT student_id, a_yesdate
				      FROM final_schedule_yesterday fsy
				      INNER JOIN final_course_student fcs ON fsy.course_id = fcs.course_id
				      WHERE (nvl(a_couttime - a_cintime, 0) - nvl(a_rettime - a_souttime, 0)) * 24 < 4
				    ) THEN 2
				    WHEN (student_id, a_date) in (
				      SELECT fcs.student_id, a_yesdate
				      FROM final_schedule_yesterday fsy
				      INNER JOIN final_course_student fcs ON fsy.course_id = fcs.course_id
				      WHERE a_cintime <= s_cindatetime AND a_couttime >= s_coutdatetime
				    ) THEN 1
				    WHEN (student_id, a_date) in (
				      SELECT student_id, a_yesdate
				      FROM final_schedule_yesterday fsy
				      INNER JOIN final_course_student fcs ON fsy.course_id = fcs.course_id
				      WHERE a_cintime IS NOT NULL AND a_couttime < s_coutdatetime
				    ) THEN 4
				    WHEN (student_id, a_date) in (
				      SELECT student_id, a_yesdate
				      FROM final_schedule_yesterday fsy
				      INNER JOIN final_course_student fcs ON fsy.course_id = fcs.course_id
				      WHERE a_couttime IS NOT NULL AND a_cintime > s_cindatetime
				    ) THEN 3
				    ELSE 2
				  END
				WHERE a_date = TRUNC(SYSDATE-1) and a_status = 0
						""");
		this.query.put("insertDailyRecords", """
				INSERT INTO final_student_attend(student_id, a_date)
				SELECT fcs.student_id AS student_id, trunc(sysdate)
				FROM final_course_student fcs
				INNER JOIN final_course fc ON fcs.course_id = fc.course_id
				WHERE sysdate BETWEEN c_sdate AND c_edate AND fc.course_id IN (SELECT * FROM final_course_today)
				  """);
	}
}