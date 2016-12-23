package com.bizee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	public ContactController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/savecontact", method = RequestMethod.POST)
	public ModelAndView saveContact(
			@ModelAttribute("command") ContactBean contactBean,
			BindingResult result) {
		System.out.println("enter");
		Contact contact = prepareModel(contactBean);
		contactService.addContact(contact);
		return new ModelAndView("redirect:/addcontact1.html");
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView listContacts() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contacts", prepareListofBean(contactService.listContacts()));
		return new ModelAndView("contactList", model);
	}

	@RequestMapping(value = "/addcontact1", method = RequestMethod.GET)
	public ModelAndView addContact(
			@ModelAttribute("command") ContactBean contactBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contacts", prepareListofBean(contactService.listContacts()));
		return new ModelAndView("addContact", model);
	}

	@RequestMapping(value = "/contactindex", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("contactindex");
	}

	@RequestMapping(value = "/deletecontact", method = RequestMethod.GET)
	public ModelAndView editContact(
			@ModelAttribute("command") ContactBean contactBean,
			BindingResult result) {
		contactService.deleteContact(prepareModel(contactBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contact", null);
		model.put("contacts", prepareListofBean(contactService.listContacts()));
		return new ModelAndView("addContact", model);
	}

	@RequestMapping(value = "/editcontact", method = RequestMethod.GET)
	public ModelAndView deleteContact(
			@ModelAttribute("command") ContactBean contactBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("contact", prepareContactBean(contactService
				.getContact(contactBean.getId())));
		model.put("contacts", prepareListofBean(contactService.listContacts()));
		return new ModelAndView("addContact", model);
	}

	private Contact prepareModel(ContactBean contactBean) {
		Contact contact = new Contact();
		contact.setUserName(contactBean.getUsername());
		contact.setPassword(contactBean.getPassword());
		contact.setName(contactBean.getName());
		contact.setId(contactBean.getId());
		contactBean.setId(null);
		return contact;
	}

	private List<ContactBean> prepareListofBean(List<Contact> contacts) {
		List<ContactBean> beans = null;
		if (contacts != null && !contacts.isEmpty()) {
			beans = new ArrayList<ContactBean>();
			ContactBean bean = null;
			if (contacts.size() != 0) {
				for (Contact contact : contacts) {
					bean = new ContactBean();
					bean.setUsername(contact.getUserName());
					bean.setId(contact.getId());
					bean.setPassword(contact.getPassword());
					bean.setName(contact.getName());
					beans.add(bean);
				}
			}
		}
		return beans;
	}

	private ContactBean prepareContactBean(Contact contact) {
		ContactBean bean = new ContactBean();
		bean.setUsername(contact.getUserName());
		bean.setPassword(contact.getPassword());
		 bean.setName(contact.getName());
		bean.setId(contact.getId());
		return bean;
	}
}
