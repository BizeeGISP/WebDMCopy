package com.bizee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/form1")
public class FormController {
	
	public FormController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/url.html", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("redirect:/form1");
	}
	
	
}
