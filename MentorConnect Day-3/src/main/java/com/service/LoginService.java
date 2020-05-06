package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.LoginBean;
import com.bean.RegistrationBean;
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

	public LoginBean find(String username, String password) {
		LoginBean result = logindao.find(username, password);

		return result;
	}

	public int insert(RegistrationBean registrationBean) {
		int insert = logindao.insert(registrationBean);
		System.out.println("Total rows inserted: " + insert);
		return insert;

	}

	public List<RegistrationBean> findRegistrationDetails() {
		List<RegistrationBean> registrationDetails = logindao.findRegistrationDetails();
		return registrationDetails;
	}

}
