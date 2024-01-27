package com.hexaware.dto;

import java.util.List;

public class Bank {
	private String name;
	private List<BankAccount> accountList;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(String name, List<BankAccount> accountList) {
		super();
		this.name = name;
		this.accountList = accountList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BankAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<BankAccount> accountList) {
		this.accountList = accountList;
	}
	
	
}
