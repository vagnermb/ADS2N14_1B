package com.model;

public class Ingrediente {

	private double quantidade;
	private String nome;
	private UnidadeMedida medida;

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeMedida getMedida() {
		return medida;
	}

	public void setMedida(UnidadeMedida medida) {
		this.medida = medida;
	}

	public void add(Ingrediente ingrediente) {

	}

}
