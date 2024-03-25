package sample.account;

import java.sql.Date;

public class Deposit {
	
	private Account account;
	private Date date;
	private double amount;
	
	public Deposit(Account account, double amount, Date date) {
		super();
		this.setAccount(account);
		this.setAmount(amount);
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
