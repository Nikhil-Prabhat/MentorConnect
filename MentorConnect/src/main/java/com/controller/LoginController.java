package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.LoginBean;

@Controller
public class LoginController {

	

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
	
			mv.addObject("user", loginBean);
			mv.setViewName("success");
	

		return mv;

	}

}
