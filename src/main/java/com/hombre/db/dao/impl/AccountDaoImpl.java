package com.hombre.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hombre.db.dao.AccountDao;
import com.hombre.db.model.Account;

@Repository
public class AccountDaoImpl extends BaseDaoImpl<Account, Long> implements AccountDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<Account> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from accounts").list();
    }

    @Override
    public Account getByID(final Integer id) {
        return (Account)sessionFactory.getCurrentSession().get(Account.class, id);
    }
}
