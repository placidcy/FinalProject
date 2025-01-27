package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.project.model.AttendanceDAO;
import com.project.model.AttendanceSO;
import com.project.model.CourseDAO;
import com.project.model.CourseDO;
import com.project.model.InstructorCalendar;
import com.project.model.InstructorCalendarTrans;
import com.project.model.MemberDAO;
import com.project.model.MemberSO;
import com.project.model.StudentAttendanceDO;

public class Test {
	public static void main(String[] args) {
		DataSource ds = new DataSource();

		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setInitialSize(5);
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3);
		ds.setTimeBetweenEvictionRunsMillis(1000 * 10);
		
		AttendanceDAO attDao = new AttendanceDAO(ds);
		CourseDAO courseDao = new CourseDAO(ds);
		MemberDAO memberDao = new MemberDAO(ds);
		MemberSO memberSo = new MemberSO();
		AttendanceSO attSO = new AttendanceSO();
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		List<InstructorCalendarTrans> insCalendarTransList = new ArrayList<InstructorCalendarTrans>();
		insCalendarTransList = attSO.getTransInsCalendar(2, 2024, 10);
		for(InstructorCalendarTrans insCalendar : insCalendarTransList) {
		System.out.println(insCalendar.getInsCalendar());
		}

	}

}
