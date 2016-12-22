package com.bizee.service;

import java.util.List;



import com.bizee.model.Contact;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContacts();

	public Contact getContact(int id);

	public void deleteContact(Contact contact);
	
	public String findContact(Contact contact);

}
