package senac.banco.model;

public class CSpecial extends Conta {

	private double limite;

	public CSpecial(int numConta, double saldo, double limite) {
		super(numConta, saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return this.limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void sacar(double valorSaque) throws SaldoInsuficiente {
		double limiteSaque = this.getSaldo() + this.getLimite();

		if (valorSaque > limiteSaque) {
			throw new SaldoInsuficiente();
		}

		super.setSaldo(this.getSaldo() - valorSaque);
	}
}
