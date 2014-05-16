package com.view;

import java.util.Scanner;

public class View {
	private static final Scanner teclado = new Scanner(System.in);

	public void showMessage(String msg) {
		System.out.println(msg);
	}

	public void showPrompt(String prompt) {
		System.out.print(prompt + ":");
	}

	public double readNumber(String prompt) {
		showPrompt(prompt);
		return readNumber();
	}

	public double readNumber() {
		return teclado.nextDouble();
	}

	public int readInt(String prompt) {
		showPrompt(prompt);
		return readInt();
	}

	public int readInt() {
		return teclado.nextInt();
	}

	public String readString(String prompt) {
		showPrompt(prompt);
		return readString();
	}

	private String readString() {
		return teclado.nextLine();
	}

	public int getMenuOption(String titulo, String[] menu) {
		int opcao = 0;
		showMessage(titulo);
		for (int i = 0; i < menu.length; ++i) {
			showMessage((i + 1) + " " + menu[i]);
		}
		opcao = readInt("Opcao");
		skipLineBreak();
		return opcao;
	}

	private void skipLineBreak() {
		teclado.nextLine();
	}

}