package senac.banco.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import senac.banco.model.SaldoInsuficiente;
import senac.banco.model.Clientes;
import senac.banco.model.Conta;
import senac.banco.model.CSpecial;
import senac.banco.model.Investimento;
import senac.banco.view.ViewSistema;

public class Controle {
	private static final Conta Contas = null;
	ViewSistema sistemaV;
	Clientes cliente;

	public Controle() {
		this.sistemaV = new ViewSistema();
		cliente = null;
		this.sistemaV.msgBoasVindas();
	}

	public void iniciarSistema() {
		String opcao = sistemaV.menuPrincipal();
		switch (opcao.toUpperCase()) {
		case "1":
			this.cadastrarConta();
			break;
		case "2":
			this.transacoesConta();
			break;
		case "S":
			sistemaV.msgEncerrando();
			break;
		default:
			sistemaV.msgOpInvalida();
			break;
		}
	}

	public void cadastrarConta() {
		Conta conta = null;
		String nome = sistemaV.entradaNome();
		boolean continuar = true;
		do {
			String tipoConta = sistemaV.menuTipoConta();
			switch (tipoConta.toUpperCase()) {
			case "C":
				conta = this.cadastrarContaComum();
				continuar = false;
				break;
			case "E":
				conta = this.cadastrarContaEspecial();
				continuar = false;
				break;
			case "I":
				conta = this.cadastrarContaInvestimento();
				continuar = false;
				break;
			default:
				sistemaV.msgOpInvalida();
				break;
			}
		} while (continuar);

		this.cliente = new Clientes(nome, conta);
		sistemaV.cadastroEfetuado(
				Integer.toString(this.cliente.getConta().getNumConta()),
				Integer.toString(this.cliente.getConta().getNumVerificacao()));
	}

	public Conta cadastrarContaComum() {
		int numConta = sistemaV.entradaNumeroConta();
		double saldo = sistemaV.entradaSaldo();
		Conta conta = new Conta(numConta, saldo);
		return conta;
	}

	public Conta cadastrarContaEspecial() {
		int numConta = sistemaV.entradaNumeroConta();
		double saldo = sistemaV.entradaSaldo();
		double limite = sistemaV.entradaLimite();
		CSpecial conta = new CSpecial(numConta, saldo, limite);
		return conta;
	}

	public Conta cadastrarContaInvestimento() {
		int numConta = sistemaV.entradaNumeroConta();
		double saldo = sistemaV.entradaSaldo();
		Investimento conta = new Investimento(numConta, saldo);
		return Investimento;

	}

	public void transacoesConta() {
		if (this.cliente == null) {
			sistemaV.clienteNaoCadastrado();
			return;
		}
		String opcao = sistemaV.menuTransacoesConta();
		switch (opcao.toUpperCase()) {
		case "1":
			this.sacar();
			break;
		case "2":
			this.depositar();
			break;
		case "3":
			this.taxaDividendo();
			break;
		case "4":
			this.consultarSaldo();
			break;
		case "V":
			break;
		default:
			sistemaV.msgOpInvalida();
			break;
		}
	}

	public void sacar() {
		double valorSaque = sistemaV.entradaValorSaque();
		try {
			this.cliente.getConta().sacar(valorSaque);
			sistemaV.saqueEfetuado();
		} catch (SaldoInsuficiente sf) {
			sistemaV.saldoInsuficiente();
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.getStackTrace();
		}
	}

	public void depositar() {
		double valorDeposito = sistemaV.valorDeposito();
		try {
			this.cliente.getConta().depositar(valorDeposito);
			sistemaV.depositoEfetuado();
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.getStackTrace();
		}
	}

	public void taxaDividendo() {
		try {
			if (this.cliente.getConta() != null) {
				double taxaDividendo = sistemaV.entradaTaxaDividendo();
				this.cliente.getConta();
				this.dividendos(taxaDividendo);
				sistemaV.dividendoEfetuado();
			} else {
				sistemaV.msgOpInexistente();
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.getStackTrace();
		}
	}

	private void dividendos(double taxaDividendo) {
	}

	public void consultarSaldo() {
		sistemaV.exibeSaldo(this.cliente.getNome(), this.cliente.getConta()
				.getNumConta(), this.cliente.getConta().getNumVerificacao(),
				this.cliente.getConta().getSaldo());

	}
}
