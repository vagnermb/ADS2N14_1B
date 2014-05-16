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

	public void voltar() {
		nivelComb--;
		posicao--;

	}

	public void carregar() throws tanqueCheioException {
		if (nivelComb == 6) {
			throw new tanqueCheioException();
		} else if (mapa[posicao] > 0 || posicao == 0)
			nivelComb++;
		mapa[posicao]--;
	}

	public void descarregar() throws SemCombustivelException {

		if (nivelComb > 0) {
			nivelComb--;
			mapa[posicao]++;
		} else
			throw new SemCombustivelException();

	}

	public Object getMapa(int posatual) {

		return mapa[posatual];
	}
}
