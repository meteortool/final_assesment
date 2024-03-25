package sample.account.comespelhamento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sample.account.Account;
import sample.account.Deposit;

public abstract class AccountTest <T extends Account>  {
	
	protected T account;
	
	@BeforeEach
	public void setup() {
		account = this.createAccount();
	}
	
	public abstract T createAccount();

    @SuppressWarnings("deprecation")
	@Test
    public void testAddDeposit() {      
        assertEquals(0, account.getDeposits().size());

		Deposit deposit = new Deposit(account, 100.0, new Date(2024, 3, 19));
        account.addDeposit(deposit);

        assertEquals(1, account.getDeposits().size());
        assertEquals(deposit, account.getDeposits().get(0));
    }

	@SuppressWarnings("deprecation")
	@Test
    public void testGetAmountDepositAvg() {
        assertEquals(0.0, account.getAmountDepositAvg(), 0.001);

        List<Deposit> deposits = new ArrayList<>();
        deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
        deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
        account.setDeposits(deposits);

        assertEquals(150.0, account.getAmountDepositAvg(), "Validação da média");
    }

    @SuppressWarnings("deprecation")
	@Test
    public void testGetSumDeposit() {
        assertEquals(0.0, account.getSumDeposit(), 0.001);

        List<Deposit> deposits = new ArrayList<>();
        deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
        deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
        account.setDeposits(deposits);

        assertEquals(300.0, account.getSumDeposit(), 0.001);
    }

    @Test
    public void testGetAmountDepositAvg_EmptyDepositsList() {
        assertEquals(0.0, account.getAmountDepositAvg());
    }

    @Test
    public void testGetSumDeposit_EmptyDepositsList() {
        assertEquals(0.0, account.getSumDeposit());
    }

    @Test
    public void testAddNullDeposit() {
        assertEquals(0, account.getDeposits().size());
        account.addDeposit(null);
        assertEquals(0, account.getDeposits().size());
    }
    
}
