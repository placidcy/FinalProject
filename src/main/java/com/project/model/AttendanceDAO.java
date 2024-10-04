package com.project.model;

import java.sql.*;
import java.util.*;
import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class AttendanceDAO {

	private JdbcTemplate jdbcTemplate;
	private String sql;

	public AttendanceDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<StudentAttendanceDO> selectAllMemberAttendanceByCourse(int course_id){
		this.sql = "select student_id, m_name, m_dept, m_tel, c, ab, l, d from (select fsa.student_id, a_status, m_name, m_dept, m_tel from final_student_attend fsa inner join (select student_id, m_name, m_dept, m_tel from final_member fm inner join (select * from final_course_student where course_id = ?) fcs on fm.member_id=fcs.member_id) fcm  on fsa.student_id=fcm.student_id) pivot (count(a_status) for a_status in (1 as c, 2 as ab, 3 as l, 4 as d)) order by student_id";	

		return this.jdbcTemplate.query(this.sql, new RowMapper<StudentAttendanceDO>() {
			@Override
			public StudentAttendanceDO mapRow(ResultSet rs, int rownum) throws SQLException{
				StudentAttendanceDO studentAtt = new StudentAttendanceDO();
				studentAtt.setStudent_id(rs.getInt(1));
				studentAtt.setM_name(rs.getString(2));
				studentAtt.setM_dept(rs.getString(3));
				studentAtt.setM_tel(rs.getString(4));
				studentAtt.setC(rs.getLong(5));
				studentAtt.setAb(rs.getLong(6));
				studentAtt.setL(rs.getLong(7));
				studentAtt.setD(rs.getLong(8));
				return studentAtt;
			}
		},course_id);
	}
	
	
	public List<StudentAttendanceDO> selectStudentAttendance(int student_id) {
		this.sql ="select * from final_student_attend where student_id=?";
		return this.jdbcTemplate.query(this.sql, new RowMapper<StudentAttendanceDO>() {
			@Override
			public StudentAttendanceDO mapRow(ResultSet rs, int rownum) throws SQLException{
				StudentAttendanceDO studentAtt = new StudentAttendanceDO();
				studentAtt.setA_date(rs.getTimestamp("a_date").toLocalDateTime());
				studentAtt.setA_status(rs.getInt("a_status"));
				return studentAtt;
			}
		},student_id);
	}
	
	public StudentAttendanceDO getStudentAttendance(int student_id) {
		this.sql = "select student_id, m_name, m_dept, m_tel, c, ab, l, d from (select fsa.student_id, a_status, m_name, m_dept, m_tel from final_student_attend fsa inner join (select student_id, m_name, m_dept, m_tel from final_member fm inner join (select * from final_course_student where student_id = ?) fcs on fm.member_id=fcs.member_id) fcm  on fsa.student_id=fcm.student_id) pivot (count(a_status) for a_status in (1 as c, 2 as ab, 3 as l, 4 as d)) order by student_id";	
	
		return this.jdbcTemplate.queryForObject(this.sql, new RowMapper<StudentAttendanceDO>() {
			@Override
			public StudentAttendanceDO mapRow(ResultSet rs, int rownum) throws SQLException{
				StudentAttendanceDO studentAtt = new StudentAttendanceDO();
				studentAtt.setStudent_id(rs.getInt(1));
				studentAtt.setM_name(rs.getString(2));
				studentAtt.setM_dept(rs.getString(3));
				studentAtt.setM_tel(rs.getString(4));
				studentAtt.setC(rs.getLong(5));
				studentAtt.setAb(rs.getLong(6));
				studentAtt.setL(rs.getLong(7));
				studentAtt.setD(rs.getLong(8));
				return studentAtt;
			}
		},student_id);
	}
	
	public List<CourseScheduleDO> getCourseDateInfo(int course_id) {
		this.sql = "select * from final_course_schedule where course_id=?";
	
		return this.jdbcTemplate.query(this.sql, new RowMapper<CourseScheduleDO>() {
			@Override
			public CourseScheduleDO mapRow(ResultSet rs, int rownum) throws SQLException{
				CourseScheduleDO courseSchedule = new CourseScheduleDO();
				courseSchedule.setS_stime(rs.getString("s_stime"));
				courseSchedule.setS_etime(rs.getString("s_etime"));
				courseSchedule.setS_cinterm(rs.getInt("s_cinterm"));
				courseSchedule.setS_coutterm(rs.getInt("s_coutterm"));
				courseSchedule.setS_sdate(rs.getTimestamp("s_sdate").toLocalDateTime());
				courseSchedule.setS_edate(rs.getTimestamp("s_edate").toLocalDateTime());	
				return courseSchedule;
			}
		},course_id);
	}
	
	public void updateAttendanceScore(CourseDO courseDO) {
		this.sql="update final_course set c_prsscore=?, c_absscore=?, c_trdscore=? where course_id=?";
		this.jdbcTemplate.update(this.sql, courseDO.getC_prsscore(),courseDO.getC_absscore(),courseDO.getC_trdscore(), courseDO.getCourse_id());
	}
	
	
	public List<StudentAttendanceDO> searchMemberAttendance(int course_id, String searchType, String searchText){
		if(searchType.equals("name")) {
			this.sql = "select m_name, m_dept, c, ab, l from (select fsa.student_id, a_status, m_name, m_dept from final_student_attend fsa inner join (select student_id, m_name, m_dept from final_member fm inner join (select * from final_course_student where course_id = ?) fcs on fm.member_id=fcs.member_id) fcm  on fsa.student_id=fcm.student_id) pivot (count(a_status) for a_status in (1 as c, 2 as ab, 3 as l)) where m_name like '%"+ searchText +"%' order by student_id";	
		}else {
			this.sql = "select m_name, m_dept, c, ab, l from (select fsa.student_id, a_status, m_name, m_dept from final_student_attend fsa inner join (select student_id, m_name, m_dept from final_member fm inner join (select * from final_course_student where course_id = ?) fcs on fm.member_id=fcs.member_id) fcm  on fsa.student_id=fcm.student_id) pivot (count(a_status) for a_status in (1 as c, 2 as ab, 3 as l)) where m_dept like '%"+ searchText +"%' order by student_id";	
		}
		
		return this.jdbcTemplate.query(this.sql, new RowMapper<StudentAttendanceDO>() {
			@Override
			public StudentAttendanceDO mapRow(ResultSet rs, int rownum) throws SQLException{
				StudentAttendanceDO studentAtt = new StudentAttendanceDO();
				studentAtt.setM_name(rs.getString(1));
				studentAtt.setM_dept(rs.getString(2));	
				studentAtt.setC(rs.getLong(3));
				studentAtt.setAb(rs.getLong(4));
				studentAtt.setL(rs.getLong(5));
				return studentAtt;
			}
		},course_id);
	}
	
	

	
}
