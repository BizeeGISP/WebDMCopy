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

import com.bizee.bean.ProfileBean;
import com.bizee.model.Profile;
import com.bizee.service.IprofileService;

@Controller
public class ProfileController {
	@Autowired
	private IprofileService iProfileService;

	public ProfileController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/profileindex", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("profileindex");

	}

	@RequestMapping(value = "/saveprofile", method = RequestMethod.POST)
	public ModelAndView saveProfile(
			@ModelAttribute("command") ProfileBean profileBean,
			BindingResult result) {

		Profile profile = prepareModel(profileBean);

		iProfileService.addProfile(profile);
		return new ModelAndView("redirect:/addprofile1.html");
	}

	@RequestMapping(value = "/profiles1", method = RequestMethod.GET)
	public ModelAndView profileList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profiles", prepareListofBean(iProfileService.profileList()));
		return new ModelAndView("profileList", model);
	}

	@RequestMapping(value = "/addprofile1", method = RequestMethod.GET)
	public ModelAndView addProfile(
			@ModelAttribute("command") ProfileBean profileBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profiles", prepareListofBean(iProfileService.profileList()));
		return new ModelAndView("addprofile", model);
	}

	@RequestMapping(value = "/deleteprofile", method = RequestMethod.GET)
	public ModelAndView editStudent(
			@ModelAttribute("command") ProfileBean profileBean,
			BindingResult result) {

		iProfileService.deleteProfile(prepareModel(profileBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profile", null);
		model.put("profiles", prepareListofBean(iProfileService.profileList()));
		return new ModelAndView("addprofile", model);
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.GET)
	public ModelAndView editProfile(
			@ModelAttribute("command") ProfileBean profileBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profile", prepareProfileBean(iProfileService
				.getProfile(profileBean.getId())));
		model.put("profiles", prepareListofBean(iProfileService.profileList()));
		return new ModelAndView("addprofile", model);
	}

	private Profile prepareModel(ProfileBean profileBean) {
		Profile profile = new Profile();
		profile.setName(profileBean.getName());
		profile.setId(profileBean.getId());
		profileBean.setId(null);
		return profile;
	}

	private List<ProfileBean> prepareListofBean(List<Profile> profiles) {
		List<ProfileBean> beans = null;
		if (profiles != null && !profiles.isEmpty()) {
			beans = new ArrayList<ProfileBean>();
			ProfileBean bean = null;
			for (Profile profile : profiles) {
				bean = new ProfileBean();
				bean.setName(profile.getName());
				bean.setId(profile.getId());

				beans.add(bean);
			}
		}
		return beans;
	}

	private ProfileBean prepareProfileBean(Profile profile) {
		ProfileBean bean = new ProfileBean();

		bean.setName(profile.getName());
		bean.setId(profile.getId());
		return bean;
	}
}