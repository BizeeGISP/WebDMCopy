package com.bizee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bizee.model.Contact;


@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listContacts() {
		return (List<Contact>) sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
	}

	@Override
	public Contact getContact(int id) {
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
	}

	@Override
	public void deleteContact(Contact contact) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Contact WHERE id = "+contact.getId()).executeUpdate();
		
	}

	@Override
	public String findContact(Contact contact) {
		 return (String) (sessionFactory.getCurrentSession().createQuery("select password from Contact where username= '"+
	contact.getUserName()+"'")).uniqueResult();
		
	}

}

