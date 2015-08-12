package com.hombre.db.dao;

import java.util.List;

import com.hombre.db.model.User;

public interface UserDao extends BaseDao<User, Long>{

    List<User> getByMailFreq(String freq);
}
