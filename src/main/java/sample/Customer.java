package sample;

import sample.account.Account;

public class Customer {
	
	private String name;
	private Account account;
	
	public Customer(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public boolean isVIP() {
		return account.getAmountDepositAvg() >+ 1000;		
	}

}
