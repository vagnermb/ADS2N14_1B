package com.senac.jogo;

import static org.junit.Assert.*;
import SemCombustivelException;
import tanqueCheioException;

import org.junit.Test;
import java.util.*;

public class DesertoTeste {

	Scanner t = new Scanner(System.in);
	Deserto deserto = new Deserto();
	private int combustivel;

	@Test
	public void testaInicioDoJogo() {

		deserto.iniciaJogo();
		assertEquals(deserto.getPosicaoInicial(), 0);
		assertEquals(deserto.getNivelCombustivel(), 6);

	}

	@Test
	public void testaComandoAvancar() {

		deserto.iniciaJogo();

		deserto.avancar();

		int posAtual = deserto.getPosicaoInicial();
		int combustAtual = deserto.getNivelCombustivel();
		assertEquals(posAtual + 1, deserto.getPosicaoInicial());
		assertEquals(combustAtual - 1, deserto.getNivelCombustivel());

	}

	@Test
	public void testaComandoVoltar() {

		deserto.iniciaJogo();

		deserto.voltar();

		int posAtual = deserto.getPosicaoInicial();
		int combustAtual = deserto.getNivelCombustivel();
		assertEquals(posAtual - 1, deserto.getPosicaoInicial());
		assertEquals(combustAtual - 1, deserto.getNivelCombustivel());

	}

	public void testaCarregarCombustivel() {
		{
			deserto.iniciaJogo();
			deserto.avancar();
			deserto.voltar();
			int combutivel = deserto.getNivelCombustivel();

			deserto.carregar();

			assertEquals(combustivel + 1, deserto.getNivelCombustivel());
		}
	}

}
