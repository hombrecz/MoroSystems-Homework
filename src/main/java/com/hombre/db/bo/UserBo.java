package com.hombre.db.bo;

import java.util.List;

import com.hombre.db.model.User;

public interface UserBo {
	void save(User user);

	void update(User user);

	void delete(User user);

	User getUserById(int id);

	List<User> listUser();

}
