package com.hombre.db.dao.impl;

import java.util.List;
import java.util.Iterator;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hombre.db.dao.UserDao;
import com.hombre.db.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public User getUserById(int userid) {
		User user = (User) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setFetchMode("permissions", FetchMode.JOIN)
				.add(Restrictions.idEq(userid)).uniqueResult();
		if (user != null) {
			Hibernate.initialize(user.getAccounts());
			Hibernate.initialize(user.getRole());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		List<User> users = (List<User>) sessionFactory.getCurrentSession()
				.createQuery("from User").list();

		for (Iterator<User> i = users.iterator(); i.hasNext();) {
			User item = i.next();
			Hibernate.initialize(item.getAccounts());
			Hibernate.initialize(item.getRole());
		}

		return users;
	}
}
