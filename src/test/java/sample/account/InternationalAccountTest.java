package sample.account;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InternationalAccountTest extends AccountTest {

	@Test
    public void testMoneyForeignTransfer() {
        InternationalAccount account = new InternationalAccount("USA", "USD");

        assertTrue(account.moneyForeignTransfer(null, 100.0, 20.0, "USD"));
        assertFalse(account.moneyForeignTransfer(null, 100.0, 19.0, "USD"));
    }


}
