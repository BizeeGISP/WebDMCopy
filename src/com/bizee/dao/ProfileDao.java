package com.bizee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bizee.model.Profile;

@Repository("iProfileDao")
public class ProfileDao implements IprofileDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProfile(Profile profile) {
		sessionFactory.getCurrentSession().saveOrUpdate(profile);
	}

	@SuppressWarnings("unchecked")
	public List<Profile> profileList() {
		// TODO Auto-generated method stub
		return (List<Profile>) sessionFactory.getCurrentSession().createCriteria(Profile.class).list();
	}
	
	@Override
	public Profile getProfile(int Id) {
		// TODO Auto-generated method stub
		return (Profile) sessionFactory.getCurrentSession().get(Profile.class, Id);
	}

	@Override
	public void deleteProfile(Profile profile) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Profile WHERE Id = "+profile.getId()).executeUpdate();
	}
	

}
