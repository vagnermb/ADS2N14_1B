package com.model;

public class Conta {
	private static int proxConta = 10000;

	private double saldo;
	private int numConta;
	private int numVerificacao;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.numConta = proxConta;
		proxConta++;
		this.numVerificacao = this.numConta % 100;
		this.cliente = cliente;
	}

	public void depositar(double valor) {
		if (valor > 0)
			saldo += valor;
	}

	public void sacar(double valor) throws SaldoInsuficienteException {
		if (podeSacar(valor))
			saldo -= valor;
		else
			throw new SaldoInsuficienteException();
	}

	public double getSaldo() {
		return saldo;
	}

	protected boolean podeSacar(double valor) {
		return (valor > 0) && (valor <= saldo);
	}

	public Cliente getCliente() {
		return cliente;
	}
}