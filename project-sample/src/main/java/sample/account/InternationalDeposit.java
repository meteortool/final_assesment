package sample.account;

import java.sql.Date;

public class InternationalDeposit extends Deposit {
	
	private String currency;

	public InternationalDeposit(InternationalAccount account, double amount, Date date, String currency) {
		super((Account)account, amount, date);
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
