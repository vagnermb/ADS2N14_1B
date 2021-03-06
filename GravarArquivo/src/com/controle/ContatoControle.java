package src.com.controle;

import java.util.Random;
import com.view.View;	
import com.model.ContatoModel;

public class ContatoControle {

	private ContatoModel contato = new ContatoModel();
	Random geraRandom = new Random();
	private View view = new View();
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
	public String geraTelefone() {
		return (this.geraRandom.nextInt(1000 - 100) + 100) + "-" + (this.geraRandom.nextInt(10000 - 1000) + 1000);
	}
	public void geraLista() {

		this.contato.setNome(this.gerarNome());
		this.contato.setEndereco(this.gerarEndereco());
		this.contato.setTelefone(this.geraTelefone());
		this.contato.setTipo(this.gerarTipoTelefone());

		view.imprimeContato(this.contato.getNome(), this.contato.getEndereco(),
				this.contato.getTelefone(), this.contato.getTipo());	}
}