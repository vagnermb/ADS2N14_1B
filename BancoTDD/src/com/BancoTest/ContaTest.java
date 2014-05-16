package com.BancoTest;

import static org.junit.Assert.assertTrue;

import com.model.Conta;
import com.model.SaldoInsuficienteException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContaTest {

	private Conta conta;

	@Before
	public void criar_conta_para_realizar_testes() {
		conta = new Conta(null);
	}

	@Test
	public void conta_deve_iniciar_com_saldo_zero() {

		assertTrue(conta.getSaldo() == 0);
	}

	@Test
	public void adicionando_e_removendo_valores_do_saldo()
			throws SaldoInsuficienteException {
		assertTrue(conta.getSaldo() == 0);

		float saldoAntesOperacao;
		float saldoAposOperacao;

		saldoAntesOperacao = (float) conta.getSaldo();
		conta.depositar((float) 5.12);
		saldoAposOperacao = (float) conta.getSaldo();
		assertTrue(saldoAposOperacao == (float) 5.12);

		saldoAntesOperacao = (float) conta.getSaldo();
		conta.sacar((float) 3.45);
		saldoAposOperacao = (float) conta.getSaldo();
		assertTrue(saldoAposOperacao == saldoAntesOperacao - (float) 3.45);

	}

}