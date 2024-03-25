package sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.OptionalDouble;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import sample.account.Account;
import sample.account.Deposit;
import sample.account.InternationalAccount;
import sample.account.InternationalDeposit;
import sample.account.LocalAccount;


public class CustomerTest {
	
	//final Account mockAccount = Mockito.mock(Account.class);
	//Mockito.when(mockAccount.getAmountDepositAvg()).thenReturn(999.00d);
	//Mockito.when(mockAccount.getAmountDepositAvg()).thenReturn(10001.00d);
	
	@Test
	public void checkIsCustomerIsNotVIP() {
		
		Customer customer = new Customer("John doe", new LocalAccount() {
			public double getAmountDepositAvg() {
				return 999;
			}			
		});

		assertFalse(customer.isVIP(), "The customer must not be vip");
	}
	
	
	@Test
	public void checkIsCustomerIsVIP() {
		
		Customer customer = new Customer("John doe", new LocalAccount() {
			public double getAmountDepositAvg() {
				return 1001;
			}		
		});
		
		assertTrue(customer.isVIP(), "The customer must be vip");
	}
	
	
	/*
	@Test
	public void testDepositsForVipAvg() {
		
		Customer customer = new Customer("John doe", new LocalAccount());
		customer.getAccount().addDeposit(new Deposit(customer.getAccount(), 500, null));
		customer.getAccount().addDeposit(new Deposit(customer.getAccount(), 800, null));
		customer.getAccount().addDeposit(new Deposit(customer.getAccount(), 1200, null));
		customer.getAccount().addDeposit(new Deposit(customer.getAccount(), 300, null));
		
		assertTrue(customer.getAccount().getAmountDepositAvg() == (500+800+1200+300)/4, "Deposits avg");
	}
	
	
	@Test
	public void testDepositsForVipSum() {
		
		Customer customer = new Customer("John doe", new LocalAccount());
		customer.getAccount().addDeposit(new Deposit(customer.getAccount(), 500, null));
		customer.getAccount().addDeposit(new Deposit(customer.getAccount(), 800, null));
		customer.getAccount().addDeposit(new Deposit(customer.getAccount(), 1200, null));
		customer.getAccount().addDeposit(new Deposit(customer.getAccount(), 300, null));
		
		assertTrue(customer.getAccount().getSumDeposit() == 500+800+1200+300, "Deposits total");
	}
	
	@Test
	public void testDepositsForInternationAccountVipAvg() {
		
		Customer customer = new Customer("John doe", new InternationalAccount("Brazil", "BRL"));
		customer.getAccount().addDeposit(new InternationalDeposit(((InternationalAccount)customer.getAccount()), 500, null, "USD"));
		customer.getAccount().addDeposit(new InternationalDeposit(((InternationalAccount)customer.getAccount()), 800, null, "USD"));
		customer.getAccount().addDeposit(new InternationalDeposit(((InternationalAccount)customer.getAccount()), 1200, null, "USD"));
		customer.getAccount().addDeposit(new InternationalDeposit(((InternationalAccount)customer.getAccount()), 300, null, "USD"));
		
		assertTrue(customer.getAccount().getAmountDepositAvg() == (500+800+1200+300)/4, "Deposits avg");
	}
	
	
	@Test
	public void testDepositsForInternationalAccountVipSum() {
		
		Customer customer = new Customer("John doe", new InternationalAccount("Brazil", "BRL"));
		customer.getAccount().addDeposit(new InternationalDeposit(((InternationalAccount)customer.getAccount()), 500, null, "USD"));
		customer.getAccount().addDeposit(new InternationalDeposit(((InternationalAccount)customer.getAccount()), 800, null, "USD"));
		customer.getAccount().addDeposit(new InternationalDeposit(((InternationalAccount)customer.getAccount()), 1200, null, "USD"));
		customer.getAccount().addDeposit(new InternationalDeposit(((InternationalAccount)customer.getAccount()), 300, null, "USD"));
		
		assertTrue(customer.getAccount().getSumDeposit() == 500+800+1200+300, "Deposits total");
	}
	
	@Test
	public void testEquality() {
		
		Customer customer1 = new Customer("Customer 1", new LocalAccount()),
				 customer2 = new Customer("Customer 1", customer1.getAccount());
		
		assertEquals(customer1, customer1);
	}*/
}
