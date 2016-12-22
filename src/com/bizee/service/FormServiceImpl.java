package com.bizee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.bizee.dao.FormDao;
import com.bizee.model.Form;

@Service("formService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FormServiceImpl implements FormService{
	
	
	@Autowired
	private FormDao formDao;

	@Override
	public List<Form> listForms() {
		return formDao.listForms();
	}


	@Override
	public Form getForm(int contactid) {
		return formDao.getForm(contactid);
	}

}
