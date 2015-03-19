package com.hombre.db.bo.impl;

import java.util.List;

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
	
	@Transactional
	public void save(Account account){
		accountDao.save(account);
	}
	
	@Transactional
	public void update(Account account){
		accountDao.update(account);
	}
	 
	@Transactional
	public void delete(Account account){
		accountDao.delete(account);
	}

    @Transactional
	public List<Account> listAccountById(int id) {
    	return accountDao.listAccountById(id);
	}
    
    @Transactional
	public Account getAccountById(int id) {
    	return accountDao.getAccountById(id);
	}

}
