package controller;

import java.util.*;

import model.Pessoa;
import view.ContatoView;

public class PessoaControl {
	String contact;
	String fone;
	String tipo;
	String type;
	private Pessoa contato;
	int codArea;
	int tel;
	int tel2;
	Random gerador = new Random();
	

	public String geraNumero() {

		Random cod = new Random();
		Random n3 = new Random();
		Random n4 = new Random();

		codArea = cod.nextInt(99);
		tel = n3.nextInt(999);
		tel2 = n4.nextInt(9999);

		return fone;

	}

	public String geraNomes() {

		Vector<String> nome1 = new Vector<String>();

		nome1.add("Pedro");
		nome1.add("Cris");
		nome1.add("Ana");
		nome1.add("Paula");
		nome1.add("Viviane");

		int name1 = gerador.nextInt(5);

		Vector<String> nome2 = new Vector<String>();

		nome2.add("Silva");
		nome2.add("Souza");
		nome2.add("Oliveira");
		nome2.add("Silveira");
		nome2.add("Assis");

		int name2 = gerador.nextInt(5);
		contact = nome1.get(name1) + " " + nome2.get(name2);

		return contact;

	}

	public void criarContato() {
		for (int i = 1; i < 3; i++) {
			contato = new Pessoa();
			contato.setNome1(geraNomes());
			contato.setTelefone(geraNumero());

		}
	}

	public String geraTipoTelefone() {

		Vector<String> tipagem = new Vector<String>();
		
		tipagem.add("Celular");
		tipagem.add("Casa");
		tipagem.add("Trabalho");

		int tipe = gerador.nextInt(3);
		tipo = tipagem.get(tipe);

		return tipo;
	}

	public void exibirContato(ContatoView view) {
		System.out.printf(contato.getNome1(), contato.getNome2());	
		
		System.out.println(": (" + codArea + ") " + tel + "-" + tel2);

		System.out.println(tipo);
	}
}
