package com.controle;

import java.util.Random;

import com.model.contatoModel;

public class contatoControle {

	private contatoModel contato = new contatoModel();

	Random geraRandom = new Random();

	public String gerarNome() {

		int nome1, nome2;

		String nomes[] = { "PATRICA", "ANGELA", "MARIA", "ANA", "IARA",
				"LARISSA", "AMANDA", "JOANA", "JULIA", "CAMILA", "CINTIA", "CAROL",
				"CAROLINE", "CECILIA", "EDUARDA", "DUDA", "BIA", "BEATRIZ",
				"ELIZ", "ELISANGELA" };
				String nome = "";
				nome1 = geraRandom.nextInt(20);
		String sobrenomes[] = { "SILVA", "SILVEIRA", "NUMES", "ANTUNE", "RIBAS",
				"SCHUMACHER", "SENNA", "BORGES", "FERREIRA", "SANTOS", "SOUZA",
				"SIPRIANO", "SIQUEIRA", "SILAS", "MOREIRA", "MOURA", "MESSIAS",
				"MUNHOZ", "MIRANDA", "MATIAS" };
				String sobrenome = "";
				nome2 = geraRandom.nextInt(20);

		nome = nomes[nome1];
		sobrenome = sobrenomes[nome2];
		return nome + " " + sobrenome;

	}

	public String gerarEndereco() {

		int endereco;
		String enderecos[] = { "RUA FELIPE SHCIEL", "RUA FELIPE UEBEL",
				"RUA EMILIO EBLING", "RUA EMILO BECKER", "RUA INDEPENDECIA", "AV IMPERATIRZ",
				"AV FEITORIA", "AV SAO BORJA", "AV DAS OLIVEIRAS",
				"AV JOAO BECKER", "RUA 10", "RUA 20" };
		endereco = geraRandom.nextInt(12);
		return enderecos[endereco];

	}

	public String gerarTipoTelefone() {

		int tipoTelefone;
		String tipos[] = { "Comercial", "Particular", "Casa" };
		tipoTelefone = geraRandom.nextInt(3);
		return tipos[tipoTelefone];

	}
}