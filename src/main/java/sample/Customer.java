package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Objects;

import sample.account.Account;

public class Customer {

	@Override
	public int hashCode() {
		return Objects.hash(account, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return account.equals(other.account) && name.equals(other.name);
	}

	private String name;
	private Account account;

	public Customer(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isVIP() {
		return account.getAmountDepositAvg() > 1000;
	}

	public static void saveCustomersToCSV(List<Customer> customers, String filePath, Writer writer) {
	    try (BufferedWriter fileWriter = new BufferedWriter(writer)) {
	        fileWriter.write("Name,Account,IsVIP\n");
	        for (Customer customer : customers) {
	            StringBuilder sb = new StringBuilder();
	            sb.append(customer.getName()).append(",");
	            sb.append(customer.getAccount().getInitialBalance()).append(",");
	            sb.append(customer.isVIP() ? "Yes" : "No");
	            sb.append("\n");
	            fileWriter.write(sb.toString());
	        }
	        System.out.println("Clientes salvos com sucesso no arquivo: " + filePath);
	    } catch (IOException e) {
	        System.err.println("Erro ao salvar clientes no arquivo: " + e.getMessage());
	    }
	}

}
