package sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import sample.account.Account;
import sample.account.LocalAccount;

public class CustomerGettersSettersTest {

    @Test
    public void testGetName() {
        Customer customer = new Customer("John Doe", null);
        assertEquals("John Doe", customer.getName(), "Validação do nome do cliente.");
    }

    @Test
    public void testSetName() {
        Customer customer = new Customer("John Doe", null);
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName());
    }

    @Test
    public void testGetAccount() {
        Account account = new LocalAccount(0);
        Customer customer = new Customer("John Doe", account);
        assertEquals(account, customer.getAccount());
    }

    @Test
    public void testSetAccount() {
        Account account = new LocalAccount(0);
        Customer customer = new Customer("John Doe", new LocalAccount(0));
        customer.setAccount(account);
        assertEquals(account, customer.getAccount());
    }
}
