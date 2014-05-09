package com.senac;

import com.view.View;
import com.model.Ingrediente;
import com.model.UnidadeMedida;

public class LivroReceita {

	public static void main(String[] args) {

		(new LivroReceita()).run();
	}

	public void imprimir() {
	}

	private void run() {
		UnidadeMedida gramas = new UnidadeMedida();
		gramas.setGrandeza("massa");
		gramas.setNome("Gramas");
		gramas.setUnidade("g");

		Ingrediente farinha = new Ingrediente();
		farinha.setNome("Farinha de Trigo");
		farinha.setQuantidade(500);
		farinha.setMedida(gramas);
	
		View view = new View();
		view.showMessage(String.format("%0f%s %s", farinha.getQuantidade(),
				farinha.getNome(), farinha.getMedida()));

		
		
	}
		imprimir(farinha);
	}
	}
}