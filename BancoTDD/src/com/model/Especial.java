package com.model;


public class Especial extends Conta {
	private double limite;

	public Especial(Cliente cliente, double limite) {
		super(cliente);
		if (limite < 0)
			limite = 1000.00;
		this.limite = limite;
	}

	@Override
	protected boolean podeSacar(double valor) {
		return valor <= (getSaldo() + limite);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}