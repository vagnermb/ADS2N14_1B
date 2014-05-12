package senac.controller;

import com.senac.pilha.Pilha;
import com.senac.view.View;

public class Calculadora {

	private String expressao;
	private View view;
	private Pilha<Double> numeros;
	private Pilha<String> operador;

	public Calculadora() {

		this.expressao = "";
		view = new View();
		this.numeros = new Pilha<Double>();
		this.operador = new Pilha<String>();
	}

	public void run() {

		this.expressao = view.readLine("Digite uma expressão");
		view.showMessage("--------------------");
		tratarExpressao(this.expressao);

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

			if (operador.equals("(") || this.operador.isEmpyt()) {
				this.numeros.push(Double.parseDouble(numeroString));
				this.operador.push(String.valueOf(operador));
				} else if (operador.equals(")")) {
					while (this.operador.peek().equals("(")) {
					calcular();
					}
			if (this.operador.peek().equals("(")) {
				this.operador.pull();		
				}
				} else if (getPrioridade(operador) > getPrioridade((String) this.operador
						.peek())) {
				}

			} else if (expressao.charAt(i) == '.') {
				this.numeros.push(Double.parseDouble(numeroString)); 
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
		String op = (String) operador.pop();
		double valor2 = (double) numeros.pop();
		double valor1 = (double) numeros.pop();
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

		numeros.push(resultado);
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

	private void pegarNumerosExpressao(String expressao) {
		String numeroString = "";
		for (int i = 0; i < expressao.length(); i++) {
			if (isNumero(String.valueOf(expressao.charAt(i)))) {
			numeroString += String.valueOf(expressao.charAt(i));
			} else {
				numeros.push(Double.parseDouble(numeroString));
			}
		}
	}

	private void pegarOperadoresExpressao(String expressao) {
		String operadorString = "";
		for (int i = 0; i < expressao.length(); i++) {
			if (isNumero(String.valueOf(expressao.charAt(i)))) {
			operadorString += String.valueOf(expressao.charAt(i));
			} else {
			operador.push(operadorString);
			}
		}
	}
}
