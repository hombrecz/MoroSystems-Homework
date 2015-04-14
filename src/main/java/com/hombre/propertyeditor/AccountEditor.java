package com.hombre.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.hombre.db.bo.AccountBo;
import com.hombre.db.model.Account;

public class AccountEditor extends PropertyEditorSupport {

	private final AccountBo accountBo;

	public AccountEditor(AccountBo accountBo) {
		this.accountBo = accountBo;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(accountBo.getAccountById(Integer.parseInt(text)));
	}

	@Override
	public String getAsText() {
		Account a = (Account) getValue();
		if (a == null) {
			return null;
		} else {
			return a.getId().toString();
		}
	}
}
