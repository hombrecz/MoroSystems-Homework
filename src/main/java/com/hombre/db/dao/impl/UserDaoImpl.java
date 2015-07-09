package com.hombre.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.hombre.db.dao.UserDao;
import com.hombre.db.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

}
