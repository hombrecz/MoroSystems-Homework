package com.hombre.db.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hombre.db.dao.UserDao;
import com.hombre.db.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        // return sessionFactory.getCurrentSession().createQuery("from users").list();

        List<User> users = sessionFactory.getCurrentSession().createQuery("from User").list();
        for (Iterator<User> i = users.iterator(); i.hasNext();) {
            User item = i.next();
            Hibernate.initialize(item.getAccounts());
            Hibernate.initialize(item.getRole());
        }
        return users;
    }
    @Override
    public User getByID(final Integer id) {
        User user = (User)sessionFactory.getCurrentSession().createCriteria(User.class).setFetchMode("permissions", FetchMode.JOIN)
                .add(Restrictions.idEq(id)).uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getAccounts());
            Hibernate.initialize(user.getRole());
        }
        return user;
    }
}
