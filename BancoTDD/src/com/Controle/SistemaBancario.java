package com.Controle;

import com.view.View;
import com.model.Cliente;
import com.model.Conta;
import com.model.Especial;
import com.model.Investimento;
import com.model.SaldoInsuficienteException;

public class SistemaBancario {
	private View view = new View();
	private Conta[] contas = new Conta[10];
	private int numContas = 0;

	public static void main(String[] args) {
		(new SistemaBancario()).run();
	}

	public void run() {
		String[] opcoes = { "Cria Conta Comum", "Cria Conta Especial",
				"Cria Conta Investimento", "Exclui Conta", "Gerencia Conta",
				"Fim do Programa" };
		int option = 0;
		while (option != opcoes.length) {
			option = view.getMenuOption("Menu Principal", opcoes);
			view.showMessage("Opcao selecionada: " + option);
			switch (option) {
			case 1:
				criaConta();
				break;
			case 2:
				criaContaEspecial();
				break;
			case 3:
				criaContaInvestimento();
				break;
			case 4:
				excluiConta();
				break;
			case 5:
				gerenciaConta();
				break;
			default:
				view.showMessage("Opcao Invalida.");
			}
		}
	}

	private Conta procuraConta() {
		String cpf = view.readString("CPF do Cliente");
		for (int i = 0; i < contas.length; i++) {
			if (contas[i] != null
					&& contas[i].getCliente().getCPF().equals(cpf)) {
				return contas[i];
			}
		}
		return null;
	}

	private void gerenciaConta() {
		view.showMessage("Gerenciamento de Conta");
		Conta conta = procuraConta();
		if (conta == null) {
			view.showMessage("Conta inexistente.");
		} else {
			opcoesConta(conta);
		}
	}

	private void opcoesConta(Conta conta) {
		if (conta instanceof Investimento) {
			String[] menuInvestimento = { "Saldo", "Sacar", "Depositar",
					"Dividendos" };
			int option = view.getMenuOption("Operacoes de Conta Investimento",
					menuInvestimento);
			switch (option) {
			case 1:
				saldo(conta);
				break;
			case 2:
				sacar(conta);
				break;
			case 3:
				depositar(conta);
				break;
			case 4:
				dividendos((Investimento) conta);
				break;
			default:
				view.showMessage("Opcao invalida");
			}
		} else {
			String[] menuConta = { "Saldo", "Sacar", "Depositar" };
			int option = view.getMenuOption("Operacoes de Conta", menuConta);
			switch (option) {
			case 1:
				saldo(conta);
				break;
			case 2:
				sacar(conta);
				break;
			case 3:
				depositar(conta);
				break;
			default:
				view.showMessage("Opcao invalida");
			}
		}
	}

	private void saldo(Conta conta) {
		view.showMessage("Saldo da conta: " + conta.getSaldo());
	}

	private void depositar(Conta conta) {
		view.showMessage("Saldo Anterior: " + conta.getSaldo());
		double valor = view.readNumber("Valor do Deposito");
		conta.depositar(valor);
		view.showMessage("Saldo Atual: " + conta.getSaldo());
	}

	private void sacar(Conta conta) {
		view.showMessage("Saldo Anterior: " + conta.getSaldo());
		double valor = view.readNumber("Valor do Saque");
		try {
			conta.sacar(valor);
		} catch (SaldoInsuficienteException e) {
			view.showMessage(e.getMessage());
		}
		view.showMessage("Saldo Atual: " + conta.getSaldo());
	}

	private void dividendos(Investimento conta) {
		view.showMessage("Saldo Anterior: " + conta.getSaldo());
		double taxa = view.readNumber("Taxa a ser aplicada (%)");
		conta.dividendos(taxa);
		view.showMessage("Saldo Atual: " + conta.getSaldo());
	}

	private void excluiConta() {
		view.showMessage("Exclusao de Conta");
		String cpf = view.readString("CPF do Cliente");
		for (int i = 0; i < contas.length; i++) {
			if (contas[i].getCliente().getCPF().equals(cpf)) {
				contas[i] = contas[numContas - 1];
				numContas--;
			}
		}
	}

	private Cliente criaCliente() {
		String nome, cpf;
		Cliente cliente = new Cliente();
		nome = view.readString("Nome do Cliente");
		cpf = view.readString("CPF");
		cliente.setNome(nome);
		cliente.setCPF(cpf);
		return cliente;
	}

	private void criaConta() {
		Cliente cliente = criaCliente();
		Conta conta = new Conta(cliente);
		contas[numContas] = conta;
		numContas++;
	}

	private void criaContaEspecial() {
		Cliente cliente = criaCliente();
		double limite = view.readNumber("Limite de Credito");
		Especial conta = new Especial(cliente, limite);
		contas[numContas] = conta;
		numContas++;
	}

	private void criaContaInvestimento() {
		Cliente cliente = criaCliente();
		Investimento conta = new Investimento(cliente);
		contas[numContas] = conta;
		numContas++;
	}

}