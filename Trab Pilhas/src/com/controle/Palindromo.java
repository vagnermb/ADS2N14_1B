package com.controle;

import com.modelo.Pilha;
import com.view.View;

public class Palindromo {

	private Pilha<String> palavraPilha;
	private View view;
	public Palindromo() {

		this.palavraPilha = new Pilha<String>();
		this.view = new View();

	}
	public static void main(String[] args) {
		new Palindromo().exec();
	}

	public void exec() {
		String palavra = view.readLine("Digite uma palavra");
		String resultado = "";

		for (int i = 0; i < palavra.length(); i++) {
			char temp = palavra.charAt(i);
			String temp2 = String.valueOf(temp);
			palavraPilha.push(temp2);

		}

		int tamanho = palavraPilha.size();
		for (int i = 0; i < tamanho; i++) {
			resultado = resultado + palavraPilha.pop();

		}


		if (resultado.equalsIgnoreCase((palavra))) {
			view.showMessage("a palavra " + palavra + " é um palindromo");
	
		} else {
			view.showMessage("a palavra " + palavra + " não é um palindromo");
		}
			view.showMessage(resultado);
	}
}