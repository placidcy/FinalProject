package com.project.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EmailDAO extends ItemDAO {
	private Map<String, String> query;
	private String sql;

	public EmailDAO() {
		super();
		this.init();
	}

	public int createAuth(String email, String code) {
		this.sql = this.query.get("createAuth");
		return this.getJdbcTemplate().update(sql, email, code);
	}

	public int checkAuth(String email, String code) {
		this.sql = this.query.get("checkAuth") + " AND e_code = ?";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, email, code);
	}

	public int checkAuth(String email) {
		this.sql = this.query.get("checkAuth");
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, email);
	}

	public int deleteAuth(String email) {
		this.sql = this.query.get("deleteAuth");
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, email);
	}

	public void init() {
		this.query = new HashMap<String, String>();
		this.query.put("createAuth", """
				INSERT INTO final_email
				VALUES(?, ?, sysdate)
				""");

		this.query.put("checkAuth", """
				SELECT
					count(*)
				FROM
					final_email
				WHERE
					e_email = ?
					AND sysdate BETWEEN e_date AND e_date + 3 / 24 / 60
					""");
		this.query.put("deleteAuth", """
				DELETE FROM FINAL_EMAIL
				WHERE E_EMAIL = ?
				""");
	}
}
