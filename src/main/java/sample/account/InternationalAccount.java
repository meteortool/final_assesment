package sample.account;

public class InternationalAccount extends Account {
	
	private String currency;
	private String country;
	
	public InternationalAccount(double initialBalance, String country, String currency) {
		super(initialBalance);
		this.setCountry(country);
		this.setCurrency(currency);		
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public boolean moneyForeignTransfer(InternationalAccount targetAccount, Double amount, Double tax, String currency) {			
		return tax >= 0.2 * amount;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
