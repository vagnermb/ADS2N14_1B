package com.senac.jogo;

public class Deserto {

	private int nivelComb = 0;
	private int posicao;
	private int[] mapa = new int[10];

	public int getPosicaoInicial() {
		return posicao;
	}

	public int getNivelCombustivel() {
		return nivelComb;
	}

	public void iniciaJogo() {
		nivelComb = 6;
		posicao = 0;
	}

	public void avancar() {
		nivelComb--;
		posicao++;

	}
}
