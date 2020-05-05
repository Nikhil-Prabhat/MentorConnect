package com.dao;

import com.bean.LoginBean;

public interface LoginDao {
	
	public LoginBean find(String username,String password);

}
