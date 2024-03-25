package sample.account.semespelhamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sample.account.Deposit;
import sample.account.LocalAccount;

public class LocalAccountTest {
	
	@SuppressWarnings("deprecation")
	@Test
    public void testAddDeposit() {
		LocalAccount account = new LocalAccount(0);
        assertEquals(0, account.getDeposits().size());
		Deposit deposit = new Deposit(account, 100.0, new Date(2024, 3, 19));
        account.addDeposit(deposit);
        assertEquals(1, account.getDeposits().size());
        assertEquals(deposit, account.getDeposits().get(0));
    }

	@SuppressWarnings("deprecation")
	@Test
    public void testGetAmountDepositAvg() {
		LocalAccount account = new LocalAccount(0);
        assertEquals(0.0, account.getAmountDepositAvg(), 0.001);
        List<Deposit> deposits = new ArrayList<>();
        deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
        deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
        account.setDeposits(deposits);
        assertEquals(150.0, 150.0, "Validação da média");
    }

    @SuppressWarnings("deprecation")
	@Test
    public void testGetSumDeposit() {
		LocalAccount account = new LocalAccount(0);
        assertEquals(0.0, account.getSumDeposit(), 0.001);
        List<Deposit> deposits = new ArrayList<>();
        deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
        deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
        account.setDeposits(deposits);
        assertEquals(300.0, account.getSumDeposit(), 0.001);
    }

    @Test
    public void testGetAmountDepositAvg_EmptyDepositsList() {
		LocalAccount account = new LocalAccount(0);
        assertEquals(0.0, account.getAmountDepositAvg());
    }

    @Test
    public void testGetSumDeposit_EmptyDepositsList() {		
    	LocalAccount account = new LocalAccount(0);
        assertEquals(0.0, account.getSumDeposit());
    }

    @Test
    public void testAddNullDeposit() {
		LocalAccount account = new LocalAccount(0);
        assertEquals(0, account.getDeposits().size());
        account.addDeposit(null);
        assertEquals(0, account.getDeposits().size());
    }

    @Test
    public void testMoneyLocalTransfer() {
        LocalAccount account = new LocalAccount(0);
        assertTrue(account.moneyLocalTransfer(account, 100.0, 10.0, "USD"));
        assertFalse(account.moneyLocalTransfer(account, 100.0, 9.0, "USD"));
    }
    
	@ParameterizedTest
	@CsvSource({ "100, 10", // Dados para conta local
				 "1000, 100" // Dados para conta local
	})
	public void testTaxPerc(double amount, double expectedTax) {
		LocalAccount account = new LocalAccount(0);
		assertEquals(expectedTax, account.getTax(amount), 0.01);
	}


}
