package com.dao;

import java.util.List;

import com.bean.LoginBean;
import com.bean.RegistrationBean;

public interface LoginDao {
	
	public LoginBean find(String username,String password);
	
	public int insert(RegistrationBean registrationBean);
	
	public List<RegistrationBean> findRegistrationDetails();

}
