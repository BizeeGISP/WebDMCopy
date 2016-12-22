package com.bizee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bizee.model.Form;


@Repository("formDao")
public class FormDaoImpl implements FormDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Form> listForms() {
		return (List<Form>) sessionFactory.getCurrentSession().createCriteria(Form.class).list();
		
	}

	@Override
	public Form getForm(int contactid) {
		return (Form) sessionFactory.getCurrentSession().createQuery("select *.Form, *.UrlForm" + "from Form, UrlForm" + "join " + "Form.Contactid=UrlForm.Urlid");
	}
	
	
	
	

}
