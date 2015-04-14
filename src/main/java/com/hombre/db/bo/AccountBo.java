package com.hombre.db.bo;

import java.util.List;

import com.hombre.db.model.Account;

public interface AccountBo {
	void save(Account account);

	void update(Account account);

	void delete(Account account);

	List<Account> listAccountById(int id);

	Account getAccountById(int id);

}
