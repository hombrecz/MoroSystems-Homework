package com.hombre.db.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hombre.db.dao.AccountDao;
import com.hombre.db.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void save(Account account){
		sessionFactory.getCurrentSession().save(account);
	}
 
	public void update(Account account){
		sessionFactory.getCurrentSession().update(account);
	}
 
	public void delete(Account account){
		sessionFactory.getCurrentSession().delete(account);
	}
 
	
	@SuppressWarnings("unchecked")
	public List<Account> listAccountById(int id) {
		List<Account> accounts = (List<Account>) sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM accounts WHERE accounts.\"userid\" = "+id).addEntity(Account.class).list();

		return accounts;
    }
	
	public Account getAccountById(int id) {
		Account account = (Account) sessionFactory.getCurrentSession().get(Account.class, id);
		return account;
	}
}
