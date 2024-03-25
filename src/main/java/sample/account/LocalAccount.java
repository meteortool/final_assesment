package sample.account;

public class LocalAccount extends Account {
	
	public LocalAccount(double initialBalance) {
		super(initialBalance);
	}
	
	public boolean moneyLocalTransfer(LocalAccount account, Double amount, Double tax, String currency) {			
		return tax >= 0.1 * amount;
	}

}
