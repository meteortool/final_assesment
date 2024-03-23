package sample.account;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

public abstract class AccountTest {

    @SuppressWarnings("deprecation")
	@Test
    public void testAddDeposit() {
        Account account = new LocalAccount();
        assertEquals(0, account.getDeposits().size());

		Deposit deposit = new Deposit(account, 100.0, new Date(2024, 3, 19));
        account.addDeposit(deposit);

        assertEquals(1, account.getDeposits().size());
        assertEquals(deposit, account.getDeposits().get(0));
    }

	@SuppressWarnings("deprecation")
	@Test
    public void testGetAmountDepositAvg() {
        Account account = new LocalAccount();

        assertEquals(0.0, account.getAmountDepositAvg(), 0.001);

        List<Deposit> deposits = new ArrayList<>();
        deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
        deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
        account.setDeposits(deposits);

        assertEquals(150.0, account.getAmountDepositAvg(), 0.001);
    }

    @SuppressWarnings("deprecation")
	@Test
    public void testGetSumDeposit() {
        Account account = new LocalAccount();

        assertEquals(0.0, account.getSumDeposit(), 0.001);

        List<Deposit> deposits = new ArrayList<>();
        deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
        deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
        account.setDeposits(deposits);

        assertEquals(300.0, account.getSumDeposit(), 0.001);
    }

    @Test
    public void testGetAmountDepositAvg_EmptyDepositsList() {
        Account account = new LocalAccount();

        assertEquals(0.0, account.getAmountDepositAvg(), 0.001);
    }

    @Test
    public void testGetSumDeposit_EmptyDepositsList() {
        Account account = new LocalAccount();

        assertEquals(0.0, account.getSumDeposit(), 0.001);
    }

    @Test
    public void testAddNullDeposit() {
        Account account = new LocalAccount();
        assertEquals(0, account.getDeposits().size());

        account.addDeposit(null);

        assertEquals(0, account.getDeposits().size());
    }
    

}
