package com.hombre.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.hombre.db.dao.AccountDao;
import com.hombre.db.model.Account;

@Repository
public class AccountDaoImpl extends BaseDaoImpl<Account, Long> implements AccountDao {

}
