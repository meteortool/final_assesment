package sample.account.comespelhamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sample.account.InternationalAccount;

public class InternationalAccountTest extends AccountTest<InternationalAccount> {

	@Test
    public void testMoneyForeignTransfer() {
        assertTrue(account.moneyForeignTransfer(null, 100.0, 20.0, "USD"));
        assertFalse(account.moneyForeignTransfer(null, 100.0, 19.0, "USD"));
    }
	
	@Override
	public InternationalAccount createAccount() {
		return new InternationalAccount(0, "Brazil", "BRL");
	}
	
	/*@ParameterizedTest
	@CsvSource({ "100, 20", // Dados para conta internacional
				 "1000, 200", // Dados para conta internacional
	})
	public void testTaxPerc(double amount, double expectedTax) {
		InternationalAccount account =  new InternationalAccount(0, "Brazil", "BRL");
		assertEquals(expectedTax, account.getTax(amount), "Validação da taxa");
	}*/

	@Override
	public void validateDepositTaxes() {
		assertEquals(account.getDepositTaxes(), account.getSumDeposit() * 0.2);			
	}

}
