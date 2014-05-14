package com.controle;

import com.modelo.Pilha;
import com.view.View;

public class Calculadora {

	private String operacao;
	private View view;
	private Pilha<Double> dados;
	private Pilha<String> sinal;

	public Calculadora() {

		this.operacao = "";
		view = new View();
		this.dados = new Pilha<Double>();
		this.sinal = new Pilha<String>();
	}

	public void run() {

		this.operacao = view.readLine("Digite a operação:");
		tratarExpressao(this.operacao);

	}

	public static void main(String[] args) {

		new Calculadora().run();
	}

	public void tratarExpressao(String expressao) {

		expressao += ".";
		String numeroString = "";
		String operador = "";

		for (int i = 0; i < expressao.length(); i++) {
			if (isNumero(String.valueOf(expressao.charAt(i)))) {
			numeroString += String.valueOf(expressao.charAt(i));
			} else if (isOperador(String.valueOf(expressao.charAt(i)))) {
				operador = String.valueOf(expressao.charAt(i));

			if (operador.equals("(") || this.sinal.isEmpyt()) {
				this.dados.push(Double.parseDouble(numeroString));
				this.sinal.push(String.valueOf(operador));
				} else if (operador.equals(")")) {
					while (this.sinal.peek().equals("(")) {
					calcular();
					}
			if (this.sinal.peek().equals("(")) {
				this.sinal.pull();		
				}
				} else if (getPrioridade(operador) > getPrioridade((String) this.sinal
						.peek())) {
				}

			} else if (expressao.charAt(i) == '.') {
				this.dados.push(Double.parseDouble(numeroString)); 
			}
		}
	}

	public boolean isNumero(String numeroString) {
		String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9","." };
		boolean isNumero = false;
		for (int i = 0; i < numeros.length; i++) {
		if (numeroString.equals(numeros[i])) {
			isNumero = true;
			}
		}
		return isNumero;
		}

	public boolean isOperador(String operador) {
		String[] operadores = { "+", "-", "*", "/", ")", "(" };
		boolean isOperador = false;
		for (int i = 0; i < operadores.length; i++) {
		if (operador.equals(operadores[i])) {
			isOperador = true;
			}
		}
		return isOperador;
		}

	public void calcular() {
		String op = (String) sinal.pop();
		double valor2 = (double) dados.pop();
		double valor1 = (double) dados.pop();
		double resultado = 0;
		if (op.equals("+")) {
			resultado = valor1 + valor2;
			System.out.println(valor1 + " " + op + " " + valor2 + " = "	+ resultado);
		}
		if (op.equals("-")) {
			resultado = valor1 - valor2;
			System.out.println(valor1 + " " + op + " " + valor2 + " = "	+ resultado);
		}
		if (op.equals("*")) {
			resultado = valor1 * valor2;
			System.out.println(valor1 + " " + op + " " + valor2 + " = "	+ resultado);
		}
		if (op.equals("/")) {
			resultado = valor1 / valor2;
			System.out.println(valor1 + " " + op + " " + valor2 + " = "	+ resultado);
		}

		dados.push(resultado);
	}

	private int getPrioridade(String operador) {

		if (operador.equals(")") || operador.equals("(")) {
		return 1;
		}
		
		else if (operador.equals("+") || operador.equals("-")) {
		return 2;
		}

		else if (operador.equals("*") || operador.equals("/")) {
		return 3;
	
		} else {
		return 0;
		}
	}
}
