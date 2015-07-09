package com.hombre.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.hombre.db.dao.RoleDao;
import com.hombre.db.model.Role;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, Long> implements RoleDao {
}
