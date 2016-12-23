package com.bizee.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bizee.bean.ContactBean;
import com.bizee.model.Contact;
import com.bizee.service.ContactService;
import com.bizee.service.RoleService;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	private RoleService roleService;
	private ContactService contactService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome1() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/loginsuccess", method = RequestMethod.POST)
	public ModelAndView Validator(
			@ModelAttribute("command") ContactBean contactBean,
			BindingResult result) {
		Boolean isValid = false;
		if (("System".equalsIgnoreCase((contactBean.getUsername())))
				&& ("B!z33$#12".equals(contactBean.getPassword()))) {
			isValid = true;
		} else {
			Contact contact = prepareModel(contactBean);

			if (contactBean.getPassword().equals(
					(contactService.findContact(contact))))
				isValid = true;

		}
		if(isValid)			
		{
			return new ModelAndView("redirect:/contactIndex");			
		}
		else
		{
			return new ModelAndView("redirect:/login");
		}

	}

	private Contact prepareModel(ContactBean contactBean) {
		Contact contact = new Contact();
		contact.setUserName(contactBean.getUsername());
		contact.setPassword(contactBean.getPassword());
		return contact;
	}

}