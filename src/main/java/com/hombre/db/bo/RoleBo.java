package com.hombre.db.bo;

import com.hombre.db.model.Role;

public interface RoleBo {
	void save(Role role);

	void update(Role role);

	void merge(Role role);

	void delete(Role role);
}
