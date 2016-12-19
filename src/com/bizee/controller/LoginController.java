package com.bizee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bizee.bean.UserBean;
import com.bizee.service.UserService;
import com.bizee.constants.*;

@Controller
public class LoginController {
	/*
	 * public void contextInitialise(){ new ServletContext(); }
	 */

	/*@Autowired*/
	/*private UserService userService;*/
	private BizeeConstant constant;
	
	public void BizeeConstant(){
		
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView Validator(
			@ModelAttribute("command") BizeeConstant constant,
			UserBean userbean) {
		if ((userbean.getUsername() == constant.USER_NAME)
				&& (userbean.getPassword() == constant.PASSWORD)) {
			return new ModelAndView("redirect:/login1.do");
		}

		return new ModelAndView("redirect:/login.do");
	}

/*	private User prepareModel(UserBean userBean) {
		User user = new User();
		user.setUserName(userBean.getUsername());
		user.setPassword(userBean.getPassword());
		user.setUserId(userBean.getUserid());
		userBean.setUserid(null);
		return user;
	}

	private UserBean prepareUserBean(User user) {
		UserBean bean = new UserBean();
		bean.setUsername(user.getUserName());
		bean.setPassword(user.getPassword());
		bean.setUserid(user.getUserId());
		return bean;
	}*/

}
