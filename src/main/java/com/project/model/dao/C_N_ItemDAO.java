package com.project.model.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class C_N_ItemDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public C_N_ItemDAO() {
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

		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public C_N_ItemDAO(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public String setPaging(String sql, int startNum, int endNum) {
		return String.format("""
				select *
				from (select rownum as rn, t.* from (
				""" + sql + """
				) t)
				where rn between %d and %d
				""", startNum, endNum);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}