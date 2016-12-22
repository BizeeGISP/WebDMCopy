package com.bizee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bizee.dao.IprofileDao;
import com.bizee.model.Profile;

@Service("iProfileService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class ProfileService implements IprofileService
{
	@Autowired
	private IprofileDao iProfileDao;
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(Profile profile) {
		
		// TODO Auto-generated method stub
		iProfileDao.addProfile(profile);
	}

	
	public List<Profile> profileList() {
		// TODO Auto-generated method stub
		return iProfileDao.profileList();

}
	
	@Override
	public Profile getProfile(int Id) {
		// TODO Auto-generated method stub
		return iProfileDao.getProfile(Id);
	}

	@Override
	public void deleteProfile(Profile profile) {
		System.out.println("step4");
		
		// TODO Auto-generated method stub
		iProfileDao.deleteProfile(profile);
	}




	
	

}
