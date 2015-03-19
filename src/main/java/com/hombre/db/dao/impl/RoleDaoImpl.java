package com.hombre.db.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hombre.db.dao.RoleDao;
import com.hombre.db.model.Role;


@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void save(Role role){
		sessionFactory.getCurrentSession().save(role);
	}
 
	public void update(Role role){
		sessionFactory.getCurrentSession().update(role);
	}
 
	public void delete(Role role){
		sessionFactory.getCurrentSession().delete(role);
	}
 
}
