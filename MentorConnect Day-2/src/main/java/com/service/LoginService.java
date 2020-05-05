package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.LoginBean;
import com.dao.LoginDao;

@Component
public class LoginService {
	
	@Autowired
	private LoginDao logindao;

	public LoginDao getLogindao() {
		return logindao;
	}

	public void setLogindao(LoginDao logindao) {
		this.logindao = logindao;
	}
	
	public LoginBean find(String username,String password)
	{
		LoginBean result = logindao.find(username, password);
		
		return result;
	}

}
