package senac.banco.model;

public class Clientes {
	
		private String nome;
		private Conta conta;

		public Clientes(String nome, Conta conta) {
			this.nome = nome;
			this.conta = conta;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Conta getConta() {
			return this.conta;
		}

		public void setConta(Conta conta) {
			this.conta = conta;
		}
	}