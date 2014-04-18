package senac.banco.model;

public class SaldoInsuficiente extends Exception {
	private static final long serialVersionUID = 1L;

	public SaldoInsuficiente() {
		super("Saldo insuficiente.");
	}
}
