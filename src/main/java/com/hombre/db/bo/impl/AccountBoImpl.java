package com.hombre.db.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hombre.db.bo.AccountBo;
import com.hombre.db.dao.AccountDao;
import com.hombre.db.model.Account;

@Service
public class AccountBoImpl implements AccountBo {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    @Transactional
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    @Transactional
    public void delete(Account account) {
        accountDao.remove(account);
    }

    @Override
    @Transactional
    public Account getAccountById(int id) {
        return accountDao.getByID(id);
    }

    @Override
    @Transactional
    public void merge(Account account) {
        accountDao.merge(account);

    }

}
