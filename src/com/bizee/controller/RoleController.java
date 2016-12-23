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


import com.bizee.bean.RoleBean;
import com.bizee.model.Role;
import com.bizee.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	public RoleController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(value = "/roleindex", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("roleindex");
	}
	
	
	@RequestMapping(value = "/saverole", method = RequestMethod.POST)
	public ModelAndView saveRole(@ModelAttribute("command") RoleBean roleBean,
			BindingResult result) {
		Role role = prepareModel(roleBean);
		roleService.addRole(role);
		return new ModelAndView("redirect:/addrole1.html");
	}

	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public ModelAndView listRoles() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("roles", prepareListofBean(roleService.listRoles()));
		return new ModelAndView("roleList", model);
	}

	@RequestMapping(value = "/addrole1.html", method = RequestMethod.GET)
	public ModelAndView addRole(@ModelAttribute("command") RoleBean roleBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("roles", prepareListofBean(roleService.listRoles()));
		return new ModelAndView("addRole", model);
	}

	@RequestMapping(value = "/deleterole", method = RequestMethod.GET)
	public ModelAndView editRole(@ModelAttribute("command") RoleBean roleBean,
			BindingResult result) {
		roleService.deleteRole(prepareModel(roleBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("role", null);
		model.put("roles", prepareListofBean(roleService.listRoles()));
		return new ModelAndView("addRole", model);
	}

	@RequestMapping(value = "/editrole", method = RequestMethod.GET)
	public ModelAndView deleteRole(
			@ModelAttribute("command") RoleBean roleBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("role",
				prepareRoleBean(roleService.getRole(roleBean.getRoleid())));
		model.put("roles", prepareListofBean(roleService.listRoles()));
		return new ModelAndView("addRole", model);
	}

	private Role prepareModel(RoleBean roleBean) {
		Role role = new Role();
		role.setRoleName(roleBean.getRolename());
		role.setRoleId(roleBean.getRoleid());
		roleBean.setRoleid(null);
		return role;
	}

	private List<RoleBean> prepareListofBean(List<Role> roles) {
		List<RoleBean> beans = null;
		if (roles != null && !roles.isEmpty()) {
			beans = new ArrayList<RoleBean>();
			RoleBean bean = null;
			if (roles.size() != 0) {
				for (Role role : roles) {
					bean = new RoleBean();
					bean.setRolename(role.getRoleName());
					bean.setRoleid(role.getRoleId());
					beans.add(bean);
				}
			}
		}
		return beans;
	}

	private RoleBean prepareRoleBean(Role role) {
		RoleBean bean = new RoleBean();
		bean.setRolename(role.getRoleName());
		bean.setRoleid(role.getRoleId());
		return bean;
	}

	

}
