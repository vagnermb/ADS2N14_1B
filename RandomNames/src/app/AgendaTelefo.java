package app;

import view.ContatoView;
import controller.PessoaControl;

public class AgendaTelefo {

	public static void main(String[] args) {
		for (int i = 1; i <= 50; i++) {
			PessoaControl controller = new PessoaControl();
			controller.criarContato();
			controller.exibirContato(new ContatoView());
		}
	}

}
