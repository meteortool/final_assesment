package sample.account;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public abstract class Account {
	public List<Deposit> deposits = new ArrayList<Deposit>();

	public List<Deposit> getDeposits() {
		return deposits;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}

	public void addDeposit(Deposit deposit) {
		if(deposit != null)
			this.deposits.add(deposit);
	}

	public double getAmountDepositAvg() {
		if (this.getDeposits() != null && getDeposits().size() > 0) {
			OptionalDouble average = this.getDeposits().stream().mapToDouble(Deposit::getAmount).average();
			if (average.isPresent()) {
				return average.getAsDouble();
			}
		}
		return 0.0;
	}
	
	public double getSumDeposit() {
		if (this.getDeposits() != null && getDeposits().size() > 0) {
			double sum = this.getDeposits().stream().mapToDouble(Deposit::getAmount).sum();
			return sum;
		}
		return 0.0;
		
	}

}
