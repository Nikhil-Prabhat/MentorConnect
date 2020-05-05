package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.LoginBean;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value="login1", method = RequestMethod.GET)
	public ModelAndView showLoginpage(LoginBean loginBean) {

		System.out.println("yo");
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", loginBean);
		mv.setViewName("login");
		return mv;

	}

	@RequestMapping(value = "submitlogin", method = RequestMethod.GET)
	public ModelAndView checkLoginDetails(@ModelAttribute("user") LoginBean loginBean, BindingResult result) {
			ModelAndView mv = new ModelAndView();
			LoginBean find = loginService.find(loginBean.getUserName(), loginBean.getPassword());
			
			if(find != null)
			{
			
			mv.addObject("user", loginBean);
			mv.setViewName("success");
			}
			else
			{
				mv.setViewName("Failure");
			}

		return mv;

	}

}
