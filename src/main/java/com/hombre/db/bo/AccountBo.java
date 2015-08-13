package com.hombre.db.bo;

import com.hombre.db.model.Account;

public interface AccountBo {
	void save(Account account);

	void update(Account account);
	
	void merge(Account account);

	void delete(Account account);

	Account getAccountById(int id);

}
