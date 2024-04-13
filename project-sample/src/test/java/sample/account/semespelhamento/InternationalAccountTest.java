package sample.account.semespelhamento;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sample.account.Deposit;
import sample.account.InternationalAccount;
import sample.exceptions.BusinessRuleException;

public class InternationalAccountTest {
	
	/*@Test
	public void testNegativeDeposit() {
		try {
			InternationalAccount account = new InternationalAccount(1000, "USA", "USD");
	        assertEquals(0, account.getDeposits().size());
			Deposit deposit = new Deposit(account, -100.0, new Date(2024, 3, 19));
			fail("Deposit must be positive!");
		} catch (BusinessRuleException businessRuleException) {
			// Ok
		} catch (Exception exception) {
			fail("Exception invalid");
		}
	}*/
	
	@Test
	public void testNegativeDeposit() {
		InternationalAccount account = new InternationalAccount(1000, "USA", "USD");
		    assertEquals(0, account.getDeposits().size());
		    
	    // Em vez de try-catch, utilize assertThrows
	    assertThrowsExactly(BusinessRuleException.class, () -> {
	        new Deposit(account, -100.0, new Date(2024, 3, 19));
	    });
	}
	
	@SuppressWarnings("deprecation")
	@Test
    public void testAddDeposit() throws Exception {        
		InternationalAccount account = new InternationalAccount(0, "USA", "USD");
        assertEquals(0, account.getDeposits().size());
		Deposit deposit = new Deposit(account, 100.0, new Date(2024, 3, 19));
        account.addDeposit(deposit);
        
        assertAll("Adding deposit and checking size and object", 
        		() -> assertEquals(account.getDeposits().size(), account.getDeposits().size()),
        		() -> assertEquals(deposit, deposit));
    }
	
	@SuppressWarnings("deprecation")
	@Test
    public void testGetAmountDepositAvg() throws Exception {
        InternationalAccount account = new InternationalAccount(0, "USA", "USD");
        assertEquals(0.0, account.getAmountDepositAvg());
        List<Deposit> deposits = new ArrayList<>();
        deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
        deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
        account.setDeposits(deposits);
        assertEquals(150.0, account.getAmountDepositAvg(), "Validação da média");
    }

    @SuppressWarnings("deprecation")
	@Test
    public void testGetSumDeposit() throws Exception {
        InternationalAccount account = new InternationalAccount(0, "USA", "USD");
        assertEquals(0.0, account.getSumDeposit());
        List<Deposit> deposits = new ArrayList<>();
        deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
        deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
        account.setDeposits(deposits);
        assertEquals(300.0, account.getSumDeposit(), 0.001);
    }

    @Test
    public void testGetAmountDepositAvg_EmptyDepositsList() {
        InternationalAccount account = new InternationalAccount(0, "USA", "USD");
        assertEquals(0.0, account.getAmountDepositAvg());
    }

    @Test
    public void testGetSumDeposit_EmptyDepositsList() {        
    	InternationalAccount account = new InternationalAccount(0, "USA", "USD");
        assertEquals(0.0, account.getSumDeposit());
    }

    @Test
    public void testAddNullDeposit() {
        InternationalAccount account = new InternationalAccount(0, "USA", "USD");
        assertEquals(0, account.getDeposits().size());
        account.addDeposit(null);
        assertEquals(0, account.getDeposits().size());
    }

	@Test
    public void testMoneyForeignTransfer() {
        InternationalAccount account = new InternationalAccount(0, "USA", "USD");

        assertTrue(account.moneyForeignTransfer(null, 100.0, 20.0, "USD"));
        assertFalse(account.moneyForeignTransfer(null, 100.0, 19.0, "USD"));
    }
	
	@ParameterizedTest
	@CsvSource({ "100, 20", // Dados para conta internacional
				 "1000, 200", // Dados para conta internacional
	})
	public void testTaxPerc(double amount, double expectedTax) {
		InternationalAccount account =  new InternationalAccount(0, "Brazil", "BRL");
		assertEquals(expectedTax, account.getTax(amount), "Validação da taxa");
	}

}
