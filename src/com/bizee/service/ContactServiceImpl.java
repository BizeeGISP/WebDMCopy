package com.bizee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bizee.dao.ContactDao;
import com.bizee.model.Contact;


@Service("contactService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContactServiceImpl implements ContactService {

	
	@Autowired
	private ContactDao contactDao;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addContact(Contact contact) {
		contactDao.addContact(contact);
		
	}

	@Override
	public List<Contact> listContacts() {
		return contactDao.listContacts();
	}

	@Override
	public Contact getContact(int id) {
		return contactDao.getContact(id);
	}

	@Override
	public void deleteContact(Contact contact) {
		contactDao.deleteContact(contact);
		
	}

	@Override
	public String findContact(Contact contact) {
		return contactDao.findContact(contact);
	}

}
