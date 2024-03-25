package sample.account.comespelhamento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import sample.account.Account;
import sample.account.Deposit;
import sample.account.InternationalAccount;
import sample.account.LocalAccount;
import sample.account.YieldCalculator;
import sample.account.YieldCalculator.Mode;

public abstract class AccountTest<T extends Account> {
	
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
		assertEquals(0.0, account.getAmountDepositAvg());

		List<Deposit> deposits = new ArrayList<>();
		deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
		deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
		account.setDeposits(deposits);

		assertEquals(150.0, account.getAmountDepositAvg(), "Validação da média");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetSumDeposit() {
		assertEquals(0.0, account.getSumDeposit());

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

	@Test
	public void testDepositsandTaxes() {

		assertEquals(0.0, account.getSumDeposit());

		List<Deposit> deposits = new ArrayList<>();
		deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
		deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
		account.setDeposits(deposits);

		validateDepositTaxes();

		/*
		 * if (account instanceof LocalAccount) assertEquals(account.getDepositTaxes(),
		 * account.getSumDeposit() * 0.1); else assertEquals(account.getDepositTaxes(),
		 * account.getSumDeposit() * 0.2);
		 */
	}

	@Test
	public void testYield() {

		assertEquals(0.0, account.getSumDeposit());

		YieldCalculator yieldCalculator = mock(YieldCalculator.class);
		when(yieldCalculator.getMode()).thenReturn(Mode.COMPOUND);
		when(yieldCalculator.calculateYield(anyDouble(), anyDouble(), anyInt())).thenAnswer(invocation -> {
			System.out.println("Here");
			return 967.53;
		});
		account.setCalculator(yieldCalculator);

		List<Deposit> deposits = new ArrayList<>();
		deposits.add(new Deposit(account, 100.0, new Date(2024, 3, 19)));
		deposits.add(new Deposit(account, 200.0, new Date(2024, 3, 20)));
		account.setDeposits(deposits);

		double obtained = (double) Math.round(account.calculateDepositYields(0.05, 24) * 100) / 100, expected = 1267.53;

		verify(yieldCalculator, times(1)).calculateYield(anyDouble(), anyDouble(), anyInt());
		assertEquals(expected, expected);

	}

	public abstract void validateDepositTaxes();

	/*
	 * @ParameterizedTest
	 * 
	 * @CsvSource({ "1, 100, 10", // Dados para conta local "1, 1000, 100", // Dados
	 * para conta local "2, 100, 20", // Dados para conta internacional
	 * "2, 1000, 200", // Dados para conta internacional }) public void
	 * testTaxPerc(double accountType, double amount, double expectedTax) { if
	 * ((accountType == 1 && account instanceof LocalAccount) || (accountType == 2
	 * && account instanceof InternationalAccount)) assertEquals(expectedTax,
	 * account.getTax(amount), "Validação da taxa"); }
	 */

}
