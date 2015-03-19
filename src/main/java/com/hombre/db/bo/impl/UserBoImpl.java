package com.hombre.db.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hombre.db.bo.UserBo;
import com.hombre.db.dao.UserDao;
import com.hombre.db.model.User;


@Service
public class UserBoImpl implements UserBo {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	public void save(User user){
		userDao.save(user);
	}
	
	@Transactional
	public void update(User user){
		userDao.update(user);
	}
	 
	@Transactional
	public void delete(User user){
		userDao.delete(user);
	}
	 
	@Transactional
	public User getUserById(int id){
		return userDao.getUserById(id);
	}
	
    @Transactional
    public List<User> listUser() {
 
        return userDao.listUser();
    }

}
