package com.bizee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bizee.model.Role;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listRoles() {
		return (List<Role>) sessionFactory.getCurrentSession().createCriteria(Role.class).list();
	
	}

	@Override
	public Role getRole(int roleId) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, roleId);
	}

	@Override
	public void deleteRole(Role role) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Role WHERE roleId = "+role.getRoleId()).executeUpdate();
		
	}
	
	
}
