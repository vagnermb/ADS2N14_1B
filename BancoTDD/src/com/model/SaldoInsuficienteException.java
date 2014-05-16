package com.model;

public class SaldoInsuficienteException extends Exception {
	private static final long serialVersionUID = 5647854973590513072L;

	public SaldoInsuficienteException() {
		super("Nao ha saldo suficiente para sacar.");
	}
}