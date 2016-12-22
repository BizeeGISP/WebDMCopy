package com.bizee.dao;

import java.util.List;

import com.bizee.model.Profile;

public interface IprofileDao
{
	public void addProfile(Profile profile);
	public List<Profile> profileList();
	public Profile getProfile(int Id);
    public void deleteProfile(Profile profile);

}
