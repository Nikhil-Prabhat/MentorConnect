package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bean.LoginBean;

@Component
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public LoginBean find(String username, String password) {
		LoginBean result=null;
		
		try
		{
		String sql = "select * from login where username=? and password=? ";
		result = jdbcTemplate.queryForObject(sql, new Object[] { username, password },
				(rs, rowNum) -> new LoginBean(rs.getString(1), rs.getString(2)));
		}
		catch(Exception e)
		{
			result=null;
		}

		return result;

	}

}
