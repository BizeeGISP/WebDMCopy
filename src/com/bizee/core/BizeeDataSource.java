package com.bizee.core;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BizeeDataSource extends DriverManagerDataSource {

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return EncryptDecrypt.decrypt(super.getPassword());
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return EncryptDecrypt.decrypt(super.getUrl());
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return EncryptDecrypt.decrypt(super.getUsername());
	}

}
