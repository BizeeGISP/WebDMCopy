package com.bizee.service;

import java.util.List;

import com.bizee.model.Role;

public interface RoleService {
	
	public void addRole(Role role);

	public List<Role> listRoles();

	public Role getRole(int roleId);

	public void deleteRole(Role role);
}

