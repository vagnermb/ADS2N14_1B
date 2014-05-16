package com.senac.jogo;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class DesertoTeste {

	Scanner t = new Scanner(System.in);
	Deserto deserto = new Deserto();

	@Test
	public void testaInicioDoJogo() {

		deserto.iniciaJogo();
		assertEquals(deserto.getPosicaoInicial(), 0);
		assertEquals(deserto.getNivelCombustivel(), 6);

	}

}
