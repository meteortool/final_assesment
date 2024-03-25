package sample.account.comespelhamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sample.account.LocalAccount;

public class LocalAccountTest extends AccountTest <LocalAccount> {
	
    @Test
    public void testMoneyLocalTransfer() {
        assertTrue(account.moneyLocalTransfer(account, 100.0, 10.0, "USD"));
        assertFalse(account.moneyLocalTransfer(account, 100.0, 9.0, "USD"));
    }
   
	@Override
	public LocalAccount createAccount() {
		return new LocalAccount(0);
	}
	
	//@ParameterizedTest
	@CsvSource({ "100, 10", // Dados para conta local
				 "1000, 100" // Dados para conta local
	})
	public void testTaxPerc(double amount, double expectedTax) {
		LocalAccount account = new LocalAccount(0);
		assertEquals(expectedTax, account.getTax(amount), "Validação da taxa");
	}

}
