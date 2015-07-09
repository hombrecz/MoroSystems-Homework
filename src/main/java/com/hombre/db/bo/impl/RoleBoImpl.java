package com.hombre.db.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hombre.db.bo.RoleBo;
import com.hombre.db.dao.RoleDao;
import com.hombre.db.model.Role;

@Service
public class RoleBoImpl implements RoleBo {

	@Autowired
	private RoleDao roleDao;

	@Transactional
	public void setUserDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
    @Transactional
	public void save(Role role) {
		roleDao.save(role);
	}

	@Override
    @Transactional
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
    @Transactional
	public void delete(Role role) {
		roleDao.remove(role);
	}

}
