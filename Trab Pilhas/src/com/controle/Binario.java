package com.controle;

import com.modelo.Pilha;
import com.view.View;

public class Binario {

	private Pilha<Integer> pilha;
	private View view;

	public Binario() {
		pilha = new Pilha<Integer>();
		view = new View();
	}

	public static void main(String[] args) {
		new Binario().run();
	}

	private void run() {
		view.showMessage(converteNumero(view.readInt("Digite um número")));
	}

	public String converteNumero(int numero) {
		String bin = "";
		int resto = 0;

		while (numero > 0) {
			resto = numero % 2;
			numero /= 2;
			pilha.push(resto);

		}

		while (pilha.size() > 0) {
			bin = bin + pilha.pop();
		}
		return bin;
	}
}