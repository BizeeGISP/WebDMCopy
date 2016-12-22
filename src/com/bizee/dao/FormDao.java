package com.bizee.dao;

import java.util.List;

import com.bizee.model.Form;



public interface FormDao {
	
	public Form getForm(int contactid);
	public List <Form> listForms();
}
