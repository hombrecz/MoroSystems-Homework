package com.hombre.db.dao;

import java.util.List;

import com.hombre.db.model.Account;

public interface AccountDao {
	
	void save(Account account);
	void update(Account account);
	void delete(Account account);
	List<Account> listAccountById(int id);
	Account getAccountById(int id);
}
