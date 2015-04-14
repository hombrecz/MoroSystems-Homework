package com.hombre.db.dao;

import com.hombre.db.model.Role;

public interface RoleDao {

	void save(Role role);

	void update(Role role);

	void delete(Role role);
}
