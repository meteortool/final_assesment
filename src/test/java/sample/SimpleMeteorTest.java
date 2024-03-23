package sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SimpleMeteorTest {
	
	@Test
	public void testCustomerName() {
		Customer customer = new Customer("Teste1", null);
		assertEquals("Teste1", customer.getName());
	}
	
	/*@Test
	public void testCustomerName2() {
		Customer customer = new Customer("Teste2", null);
		assertEquals("Teste2", customer.getName());		
	}
	
	@Test
	public void testCustomerName3() {
		Customer customer = new Customer("Teste3", null);
		assertEquals("Teste3", customer.getName());
	}*/

}
