package com.bizee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bizee.dao.RoleDao;
import com.bizee.model.Role;

@Service("roleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleDao roleDao;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRole(Role role) {
		roleDao.addRole(role);
		
	}

	@Override
	public List<Role> listRoles() {
		return roleDao.listRoles();
	}

	@Override
	public Role getRole(int roleId) {
		return roleDao.getRole(roleId);
	}

	@Override
	public void deleteRole(Role role) {
		roleDao.deleteRole(role);
		
	}

}

