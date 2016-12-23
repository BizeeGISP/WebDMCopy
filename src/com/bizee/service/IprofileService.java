package com.bizee.service;

import java.util.List;

import com.bizee.model.Profile;


public interface IprofileService 
{
	
	public void addProfile(Profile profile);
	public List<Profile> profileList();
    public Profile getProfile(int Id);
	public void deleteProfile(Profile profile);

}
