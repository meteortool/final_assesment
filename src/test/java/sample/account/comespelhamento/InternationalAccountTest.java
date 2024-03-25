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

public class InternationalAccountTest extends AccountTest {

	@Test
    public void testMoneyForeignTransfer() {
        InternationalAccount account = new InternationalAccount(0, "USA", "USD");

        assertTrue(account.moneyForeignTransfer(null, 100.0, 20.0, "USD"));
        assertFalse(account.moneyForeignTransfer(null, 100.0, 19.0, "USD"));
    }
	
	@ParameterizedTest
	@CsvSource({ "1, 100, 20", // Dados para conta internacional
				 "1, 1000, 200", // Dados para conta internacional
	})
	public void testTaxPerc(int accountId, double amount, double expectedTax) {
		Account account = accountId == 0 ? new LocalAccount(0) : new InternationalAccount(0, "Brazil", "BRL");
		assertEquals(expectedTax, account.getTax(amount), 0.01);
	}


}
