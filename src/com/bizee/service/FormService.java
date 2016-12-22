package com.bizee.service;

import java.util.List;

import com.bizee.model.Form;



public interface FormService {
	
	public Form getForm(int contactid);
	public List <Form> listForms();
}
