package sample.account.comespelhamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sample.account.Account;
import sample.account.InternationalAccount;
import sample.account.LocalAccount;

public class LocalAccountTest extends AccountTest {
	

    @Test
    public void testMoneyLocalTransfer() {
        LocalAccount account = new LocalAccount(0);

        assertTrue(account.moneyLocalTransfer(account, 100.0, 10.0, "USD"));
        assertFalse(account.moneyLocalTransfer(account, 100.0, 9.0, "USD"));
    }
    
	@ParameterizedTest
	@CsvSource({ "0, 100, 10", // Dados para conta local
				 "0, 1000, 100" // Dados para conta local
	})
	public void testTaxPerc(int accountId, double amount, double expectedTax) {
		Account account = accountId == 0 ? new LocalAccount(0) : new InternationalAccount(0, "Brazil", "BRL");
		assertEquals(expectedTax, account.getTax(amount), 0.01);
	}


}
