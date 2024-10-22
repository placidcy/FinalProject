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
		return this.getJdbcTemplate().update(sql, Integer.class, email, code);
	}

	public int checkAuth(String email, String code) {
		this.sql = this.query.get("checkAuth") + " and e_code = ?";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, email, code);
	}

	public int checkAuth(String email) {
		this.sql = this.query.get("checkAuth");
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, email);
	}

	public void init() {
		this.query = new HashMap<String, String>();
		this.query.put("createAuth", """
				insert into final_email
				values(?, ?, sysdate)
				""");

		this.query.put("checkAuth", """
				select count(*)
				from final_email
				where e_email = ? and sysdate between e_date and e_date + 3/24/60
				""");
	}
}
