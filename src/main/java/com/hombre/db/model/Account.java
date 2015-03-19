package com.hombre.db.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "accounts")
public class Account {
	private Integer id;
	private String name;
	private int accountPrefix;
	private long accountNumber;
	private int bankCode;
	private User user;

	public Account () {
	}
	
	public Account (String name, int accountPrefix, long accountNumber, int bankCode, User user) {
		this.name = name;
		this.accountPrefix = accountPrefix;
		this.accountNumber = accountNumber;
		this.bankCode = bankCode;
		this.user = user;
	}
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Size(min = 1, max = 999999)
	@Column(name="accountprefix")
	public int getAccountPrefix() {
		return accountPrefix;
	}

	public void setAccountPrefix(int accountPrefix) {
		this.accountPrefix = accountPrefix;
	}

	@NotNull
	@Column(name="accountnumber")
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@NotNull
	@Size(min = 1, max = 9999)
	@Column(name="bankcode")
	public int getBankCode() {
		return bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}

	@JoinColumn(name="userid")
	@ManyToOne(fetch = FetchType.LAZY)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
