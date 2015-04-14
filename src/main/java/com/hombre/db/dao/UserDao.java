package com.hombre.db.dao;

import java.util.List;

import com.hombre.db.model.User;

public interface UserDao {

	void save(User user);

	void update(User user);

	void delete(User user);

	User getUserById(int id);

	List<User> listUser();
}
