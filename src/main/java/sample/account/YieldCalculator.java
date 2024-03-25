package sample.account;

public class YieldCalculator {

	// Enum para representar os modos de cálculo
	public enum Mode {
		SIMPLE, COMPOUND
	}

	private Mode mode;

	// Construtor da classe
	public YieldCalculator(Mode mode) {
		this.mode = mode;
	}

	// Função para calcular o rendimento (lucro) com juros simples
	public double calculateSimpleInterest(double principal, double rate, int periods) {
		double interest = principal * rate * periods;
		return principal + interest;
	}

	// Função para calcular o rendimento (lucro) com juros compostos
	public double calculateCompoundInterest(double principal, double rate, int periods) {
		double amount = principal * Math.pow(1 + rate, periods);
		return amount;
	}

	// Função para calcular o rendimento de acordo com o modo selecionado
	public double calculateYield(double principal, double rate, int periods) {
		switch (mode) {
		case SIMPLE:
			return calculateSimpleInterest(principal, rate, periods);
		case COMPOUND:
			return calculateCompoundInterest(principal, rate, periods);
		default:
			System.out.println("Modo inválido.");
			return -1;
		}
	}

}