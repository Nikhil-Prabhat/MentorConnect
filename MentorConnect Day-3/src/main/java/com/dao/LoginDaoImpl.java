package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bean.LoginBean;
import com.bean.RegistrationBean;

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
	public int insert(RegistrationBean registrationBean) {

		String sql = "insert into registration values(?,?,?,?,?,?,?)";
		int insert = jdbcTemplate.update(sql, registrationBean.getName(), registrationBean.getCompanyName(),
				registrationBean.getContactNumber(), registrationBean.isGender(), registrationBean.getCity(),
				registrationBean.getState(), registrationBean.getCountry());

		return insert;

	}

	@Override
	public LoginBean find(String username, String password) {
		LoginBean result = null;

		try {
			String sql = "select * from login where username=? and password=? ";
			result = jdbcTemplate.queryForObject(sql, new Object[] { username, password },
					(rs, rowNum) -> new LoginBean(rs.getString(1), rs.getString(2)));
		} catch (Exception e) {
			result = null;
		}

		return result;

	}

	@Override
	public List<RegistrationBean> findRegistrationDetails() {
		String sql = "select * from registration";

		List<RegistrationBean> details = jdbcTemplate.query(sql, (rs, rowNum) ->

		new RegistrationBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5),
				rs.getString(6), rs.getString(7)));

		return details;

	}

}
