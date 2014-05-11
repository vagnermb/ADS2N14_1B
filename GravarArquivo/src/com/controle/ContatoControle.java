package com.controle;


import java.util.Random;

import com.model.contatoModel;


public class ContatoControle {

	private contatoModel contato = new contatoModel();
	Random geraRandom = new Random();

	public String gerarNome() {

		int nomeAleatorio, sobrenomeAleatorio;
		nomeAleatorio = geraRandom.nextInt(20);
		String nomes[] = { "BRUNA", "THACIA", "ANA", "GABY", "LARISSA",
				"CAROLINA", "CAROLINE", "CAROL", "CLARA", "SAMANTA", "MARIA", "ANGELA",
				"MAIARA", "BEATRIZ", "BIA", "BIANCA", "CARLA", "GRACIELA",
				"PATRICIA", "PATI" };
				String nome = "";
		sobrenomeAleatorio = geraRandom.nextInt(20);
		String sobrenomes[] = { "NUNES", "SILVA", "SILVEIRA", "BORGES", "ANTONIA",
				"SENNA", "SCHUMACHER", "PROST", "HAIKKONEN", "LAUDA", "BARICHELLO",
				"FITIPALDI", "KANNAAN", "MOORE", "PEDROSA", "HEIDDEN", "BLANCA",
				"PERSEFONE", "MESIAS", "MATIAS"};
				String sobrenome = "";

	
		

		nome = nomes[nomeAleatorio];
		sobrenome = sobrenomes[sobrenomeAleatorio];

		return nome + " " + sobrenome;

	}

	public String gerarEndereco() {

		int enderecoAleatorio;

		String enderecos[] = { "Olavo Bilac", "Marechal Floriano",
				"Getulio Vargas", "A", "B", "C", "Sem saída", "Sem saída", "S",
				"Das Grotas", "das Paineiras", "das Pedras" };

		enderecoAleatorio = geraRandom.nextInt(12);

		return enderecos[enderecoAleatorio];

	}

	public String gerarTipoTelefone() {

		int tipoTelefoneAleatorio;

		String tipos[] = { "R", "C", "T" };

		tipoTelefoneAleatorio = geraRandom.nextInt(3);

		return tipos[tipoTelefoneAleatorio];

	}

	public String geraTelefone() {

		return (this.geraRandom.nextInt(1000 - 100) + 100) + "-"
				+ (this.geraRandom.nextInt(10000 - 1000) + 1000);

	}

}
