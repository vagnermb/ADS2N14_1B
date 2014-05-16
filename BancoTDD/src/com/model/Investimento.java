package com.model;


public class Investimento extends Conta {
	private int dataCriacao;

	public Investimento(Cliente cliente) {
		super(cliente);
		this.dataCriacao = 0;
	}

	public void dividendos(double taxa) {
		double valor = getSaldo() * (taxa / 100.0);
		depositar(valor);
	}

	public int getDataCriacao() {
		return this.dataCriacao;
	}
}